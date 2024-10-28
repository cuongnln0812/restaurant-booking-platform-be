package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.*;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.uservoucher.ApplyUserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.uservoucher.CheckVoucherResponse;
import com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherRequest;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherResponse;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.repositories.UserVoucherRepository;
import com.foodbookingplatform.repositories.VoucherRepository;
import com.foodbookingplatform.services.VoucherService;
import com.foodbookingplatform.utils.DateTimeUtil;
import com.foodbookingplatform.utils.GenericSpecification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class VoucherServiceImpl implements VoucherService {
    private final VoucherRepository voucherRepository;
    private final UserVoucherRepository userVoucherRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public VoucherResponse createVoucher(VoucherRequest request) {
        if(voucherRepository.existsByCode(request.getCode()))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Voucher code existed!");
        Voucher newVoucher = mapper.map(request, Voucher.class);
        if(request.getMaxDiscountAmount() > request.getMinOrderAmount())
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Max discount amount cannot greater than min order amount");
        if(request.getDiscount() > 100 || request.getDiscount() < 0)
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Discount percentage must be in range of 0% - 100%");
        if(request.getQuantity() < request.getQuantityUse())
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Max quantity use must be lower than total quantity");

        newVoucher.setStatus(OfferStatus.INACTIVE);
        return mapper.map(voucherRepository.save(newVoucher), VoucherResponse.class);
    }

    @Override
    public VoucherResponse updateVoucher(VoucherRequest request) {
        Voucher existed = voucherRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Voucher", "Id", request.getId()));
        if(!request.getCode().equals(existed.getCode()))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Voucher code is unable to update!");
        if(!existed.getStatus().equals(OfferStatus.INACTIVE))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Only INACTIVE vouchers are able to update");
        mapper.map(request, existed);
        return mapper.map(voucherRepository.save(existed), VoucherResponse.class);
    }

    @Override
    public Page<VoucherResponse> viewAllVoucher(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Voucher> voucherPage;

        if(!searchParams.isEmpty()) {
            Specification<Voucher> specification = specification(searchParams);
            voucherPage = voucherRepository.findAll(specification, pageable);
        }else {
            voucherPage = voucherRepository.findAll(pageable);
        }
        return voucherPage.map(v -> mapper.map(v, VoucherResponse.class));
    }

    @Override
    public VoucherResponse getVoucherDetail(Long id) {
        Voucher existed = voucherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher", "Id", id));
        return mapper.map(existed, VoucherResponse.class);
    }

    @Override
    public VoucherResponse deleteVoucher(Long id) {
        Voucher existed = voucherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher", "Id", id));
        if(!existed.getStatus().equals(OfferStatus.DISABLED))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "This voucher is already deleted!");

        existed.setStatus(OfferStatus.DISABLED);
        return mapper.map(voucherRepository.save(existed), VoucherResponse.class);
    }

    @Override
    public List<UserVoucherResponse> viewAllVoucherOfUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        List<UserVoucher> vouchers = userVoucherRepository.findByUserUserName(username);
        if(!vouchers.isEmpty()) {
            return vouchers.stream()
                    .filter(voucher -> (voucher.getVoucher().getStatus().equals(OfferStatus.ACTIVE) ||
                            voucher.getVoucher().getStatus().equals(OfferStatus.INACTIVE)) && voucher.getQuantityAvailable() > 0)
                    .map(this::mapUserVoucherResponse)
                    .toList();
        }else return new ArrayList<>();
    }

    @Override
    public UserVoucherResponse addVoucherForUser(Long voucherId) {
        Voucher existedVoucher = voucherRepository.findById(voucherId)
                .orElseThrow(() -> new ResourceNotFoundException("Voucher", "Id", voucherId));
        UserVoucher savedUserVoucher;
        int quantityAvailable = existedVoucher.getQuantity();

        if(quantityAvailable == 0)
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Out of voucher!");
        else {
            if (!userVoucherRepository.existsByVoucher(existedVoucher)) {
                UserVoucher newUserVoucher = new UserVoucher();
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                User currUser = userRepository.findByUserName(username)
                        .orElseThrow(() -> new ResourceNotFoundException("Current user is not existed to handle this action!"));

                newUserVoucher.setVoucher(existedVoucher);
                newUserVoucher.setUser(currUser);
                newUserVoucher.setQuantityAvailable(1);
                newUserVoucher.setAssignedDate(LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
                savedUserVoucher = userVoucherRepository.save(newUserVoucher);
            } else {
                UserVoucher existedUserVoucher = userVoucherRepository.findByVoucher(existedVoucher);
                int updatedQuantity = existedUserVoucher.getQuantityAvailable() + 1;

                if (updatedQuantity <= existedVoucher.getQuantityUse()) {
                    existedUserVoucher.setQuantityAvailable(updatedQuantity);
                    existedUserVoucher.setAssignedDate(LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
                    savedUserVoucher = userVoucherRepository.save(existedUserVoucher);
                } else
                    throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You can only add max " + existedVoucher.getQuantityUse() + " vouchers");
            }
            //-1 for unlimited voucher
            if(quantityAvailable != -1){
                existedVoucher.setQuantity(quantityAvailable - 1);
            }
        }
        return mapUserVoucherResponse(savedUserVoucher);
    }

    @Override
    public CheckVoucherResponse applyVoucher(Long voucherId, Float totalPrice) {
        CheckVoucherResponse checkVoucherResponse = new CheckVoucherResponse();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(totalPrice > 0) {
            UserVoucher userVoucher = userVoucherRepository.findByVoucher_IdAndUserUserName(voucherId, username)
                    .orElseThrow(() -> new RestaurantBookingException(HttpStatus.NOT_FOUND, "You do not have this voucher to apply!"));
            Voucher voucher = checkVoucherValid(totalPrice, userVoucher);

            float discountedAmount = (totalPrice * voucher.getDiscount()) / 100;
            discountedAmount = discountedAmount > voucher.getMaxDiscountAmount() ? voucher.getMaxDiscountAmount() : discountedAmount;
            checkVoucherResponse.setVoucherId(voucherId);
            checkVoucherResponse.setDiscountedValue(discountedAmount);
            return checkVoucherResponse;
        }else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You have to pre-order foods in order to apply voucher!");
    }

    @Override
    public List<ApplyUserVoucherResponse> getUsableVoucherListOfUser(Float totalPrice) {
        List<UserVoucherResponse> userVoucherResponses = viewAllVoucherOfUser();
        return userVoucherResponses.stream()
                .map(voucher -> {
                    ApplyUserVoucherResponse applyUserVoucherResponse = mapper.map(voucher, ApplyUserVoucherResponse.class);
                    boolean isUsable = voucher.getMinOrderAmount() <= totalPrice &&
                            voucher.getQuantityAvailable() > 0 &&
                            voucher.getStatus().equals(OfferStatus.ACTIVE);
                    applyUserVoucherResponse.setUsable(isUsable);
                    return applyUserVoucherResponse;
                })
                .toList();
    }

    @Scheduled(fixedRate = 10000)
    public void handleVoucherActive() {
        List<Voucher> voucherActive = voucherRepository.findVoucherByStartDateBeforeAndStatus(DateTimeUtil.nowInVietnam(), OfferStatus.INACTIVE);
        voucherActive.forEach(v -> v.setStatus(OfferStatus.ACTIVE));
        voucherRepository.saveAll(voucherActive);
    }

    @Scheduled(fixedRate = 10000)
    public void handleVoucherExpire() {
        List<Voucher> voucherExpire = voucherRepository.findVoucherByEndDateBeforeAndStatus(DateTimeUtil.nowInVietnam(), OfferStatus.ACTIVE);
        voucherExpire.forEach(v -> v.setStatus(OfferStatus.EXPIRE));
        voucherRepository.saveAll(voucherExpire);
    }

    private Voucher checkVoucherValid(Float totalPrice, UserVoucher userVoucher) {
        Voucher voucher = userVoucher.getVoucher();

        if (voucher.getStatus() != OfferStatus.ACTIVE)
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Voucher is not available!");
        if (userVoucher.getQuantityAvailable() <= 0)
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Out of voucher quantity use!");
        if (voucher.getMinOrderAmount() > totalPrice)
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Booking does not meet the min amount for voucher!");
        return voucher;
    }

    private Specification<Voucher> specification(Map<String, Object> searchParams){
        List<Specification<Voucher>> specs = new ArrayList<>();

        searchParams.forEach((key, value) -> {
            switch (key) {
                case "status":
                    specs.add(GenericSpecification.fieldIn(key, (Collection<?>) value));
                    break;
                case "startDate":
                    if (searchParams.containsKey("endDate")) {
                        specs.add(GenericSpecification.fieldBetween("endDate", (LocalDateTime) searchParams.get("startDate"), (LocalDateTime) searchParams.get("endDate")));
                    } else {
                        specs.add(GenericSpecification.fieldGreaterThan("startDate", (LocalDateTime) value));
                    }
                    break;
                case "endDate":
                    if (!searchParams.containsKey("startDate")) {
                        specs.add(GenericSpecification.fieldLessThan("endDate", (LocalDateTime) value));
                    }
                    break;
                case "description":
                case "code":
                case "name":
                    specs.add(GenericSpecification.fieldContains(key, (String) value));
                    break;
            }
        });

        return specs.stream().reduce(Specification.where(null), Specification::and);
    }

    private UserVoucherResponse mapUserVoucherResponse(UserVoucher userVoucher){
        UserVoucherResponse response = new UserVoucherResponse();
        response.setId(userVoucher.getId());
        response.setCode(userVoucher.getVoucher().getCode());
        response.setDescription(userVoucher.getVoucher().getDescription());
        response.setDiscount(userVoucher.getVoucher().getDiscount());
        response.setMinOrderAmount(userVoucher.getVoucher().getMinOrderAmount());
        response.setMaxDiscountAmount(userVoucher.getVoucher().getMaxDiscountAmount());
        response.setQuantityAvailable(userVoucher.getQuantityAvailable());
        response.setStartDate(userVoucher.getVoucher().getStartDate());
        response.setEndDate(userVoucher.getVoucher().getEndDate());
        response.setStatus(userVoucher.getVoucher().getStatus());
        return response;
    }
}
