package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.*;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingRequest;
import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingRequest;
import com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherRequest;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherResponse;
import com.foodbookingplatform.repositories.FoodRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.repositories.UserVoucherRepository;
import com.foodbookingplatform.repositories.VoucherRepository;
import com.foodbookingplatform.services.VoucherService;
import com.foodbookingplatform.utils.GenericSpecification;
import lombok.NonNull;
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
    private final FoodRepository foodRepository;
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
        return vouchers.stream()
                .filter(voucher -> voucher.getVoucher().getStatus().equals(OfferStatus.ACTIVE) ||
                        voucher.getVoucher().getStatus().equals(OfferStatus.INACTIVE))
                .map(this::mapUserVoucherResponse)
                .toList();
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
                    throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You can only add max " + existedVoucher.getQuantityUse() + "vouchers");
            }
            //-1 for unlimited voucher
            if(quantityAvailable != -1){
                existedVoucher.setQuantity(quantityAvailable - 1);
            }
        }
        return mapUserVoucherResponse(savedUserVoucher);
    }

    @Override
    public Float applyVoucher(Long voucherId, float totalPrice) {
        if(totalPrice == 0) {
            Voucher voucher = voucherRepository.findById(voucherId)
                    .orElseThrow(() -> new ResourceNotFoundException("Voucher", "id", voucherId));

            if (voucher.getStatus() != OfferStatus.ACTIVE)
                throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Voucher is not available!");

            if (voucher.getMinOrderAmount() > totalPrice)
                throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Booking does not meet the min amount for voucher!");

            return (totalPrice * voucher.getDiscount());
        }else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You have to pre-order foods in order to apply voucher!");
    }



    @Scheduled(fixedRate = 10000)
    public void handleVoucherActive() {
        List<Voucher> voucherActive = voucherRepository.findVoucherByStartDateAndStatus(LocalDateTime.now(), OfferStatus.INACTIVE);
        voucherActive.forEach(v -> v.setStatus(OfferStatus.ACTIVE));
        voucherRepository.saveAll(voucherActive);
    }

    @Scheduled(fixedRate = 10000)
    public void handleVoucherExpire() {
        List<Voucher> voucherExpire = voucherRepository.findVoucherByEndDateAndStatus(LocalDateTime.now(), OfferStatus.ACTIVE);
        voucherExpire.forEach(v -> v.setStatus(OfferStatus.EXPIRE));
        voucherRepository.saveAll(voucherExpire);
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
        return response;
    }
}
