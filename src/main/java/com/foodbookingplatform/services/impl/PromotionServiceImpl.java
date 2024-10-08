package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.*;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionRequest;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionResponse;
import com.foodbookingplatform.repositories.LocationRepository;
import com.foodbookingplatform.repositories.PromotionRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.PromotionService;
import com.foodbookingplatform.utils.GenericSpecification;
import com.foodbookingplatform.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.foodbookingplatform.models.enums.PromotionType.BILL;
import static com.foodbookingplatform.models.enums.PromotionType.PEOPLE;
import static com.foodbookingplatform.models.enums.PromotionType.TIME;

@Service
@Transactional
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public PromotionResponse addPromotion(PromotionRequest promotionRequest) {
        return mapToResponse(promotionRepository.save(validate(promotionRequest, promotionRequest.getId())));
    }

    @Override
    public PromotionResponse getPromotion(Long id) {
        Promotion promotion = promotionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promotion", "id", id));
        return mapToResponse(promotion);
    }

    @Override
    public Page<PromotionResponse> getAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Promotion> promotionPage = promotionRepository.findAll(pageable);
        return promotionPage.map(this::mapToResponse);
    }

    @Override
    public Page<PromotionResponse> getAllPromotionsOfLocation(int pageNo, int pageSize, String sortBy, String sortDir, long id) throws AccessDeniedException {
        boolean isAuthorize = SecurityUtils.isAuthorizeLocation(id, userRepository);
        if (!isAuthorize) {
            throw new AccessDeniedException("You do not have permission to access promotions for this location.");
        }

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Promotion> promotionPage = promotionRepository.getPromotionByLocation_Id(id, pageable);
        return promotionPage.map(this::mapToResponse);
    }

    @Override
    public Page<PromotionResponse> searchAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Specification<Promotion> specification = specification(searchParams);

        Page<Promotion> promotionPage = promotionRepository.findAll(specification, pageable);

        return promotionPage.map(this::mapToResponse);
    }

    @Override
    public PromotionResponse updatePromotion(PromotionRequest promotionRequest) throws AccessDeniedException {
        boolean isAuthorize = SecurityUtils.isAuthorizeLocation(promotionRequest.getLocationId(), userRepository);
        if (!isAuthorize) {
            throw new AccessDeniedException("You do not have permission to access promotions for this location.");
        }

        Promotion updatedPromotion = validate(promotionRequest, promotionRequest.getId());
        return mapToResponse(updatedPromotion);
    }

    @Override
    public void deletePromotion(long id) throws AccessDeniedException {
        boolean isAuthorize = SecurityUtils.isAuthorizeLocation(id, userRepository);
        if (!isAuthorize) {
            throw new AccessDeniedException("You do not have permission to access promotions for this location.");
        }

        Promotion promotion = promotionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Promotion", "id", id));
        promotion.setStatus(OfferStatus.DISABLED);
        promotionRepository.save(promotion);
    }

    @Override
    public float applyPromotion(Long promotionId, float totalPrice, int numberOfPeople,
                                LocalDate bookingDate, LocalTime bookingTime) {
        float discountAmount = 0.0f;

        Promotion promotion = promotionRepository.findById(promotionId)
                .orElseThrow(() -> new ResourceNotFoundException("Promotion", "id", promotionId));
        if (promotion.getStatus() != OfferStatus.ACTIVE)
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Promotion is not available!");

        switch (promotion.getType()){
            case "BILL" -> discountAmount = applyBillPromotion(promotion, totalPrice);
            case "PEOPLE" -> discountAmount = applyPeoplePromotion(promotion, numberOfPeople);
            case "TIME" -> discountAmount = applyTimePromotion(promotion, bookingDate, bookingTime);
        }

        return discountAmount;
    }

    private float applyTimePromotion(Promotion promotion, LocalDate bookingDate, LocalTime bookingTime) {
        if(isDateTimeInRange(bookingDate, bookingTime, promotion.getStartDate(), promotion.getStartHourTime(),
                promotion.getEndDate(), promotion.getEndHourTime())){
            if(promotion.getDiscountValue() != 0) return Float.parseFloat(promotion.getDiscountValue().toString());
            else return 0;
        }else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Cannot apply this promotion: Date Time invalid!");
    }

    private float applyPeoplePromotion(Promotion promotion, int numberOfPeople) {
        if(promotion.getMinPeople() <= numberOfPeople){
            if(promotion.getDiscountValue() != 0) return Float.parseFloat(promotion.getDiscountValue().toString());
            else return 0;
        }else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Cannot apply this promotion: Min number of people invalid!");
    }

    private float applyBillPromotion(Promotion promotion, float totalPrice) {
        if(promotion.getMinBill() <= totalPrice){
            if(promotion.getDiscountValue() != 0) return Float.parseFloat(promotion.getDiscountValue().toString());
            else return 0;
        }else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Cannot apply this promotion: Min number of bill invalid!");
    }

    public boolean isDateTimeInRange(LocalDate dateToCheck, LocalTime timeToCheck,
                                     LocalDateTime startDate, LocalTime startTime,
                                     LocalDateTime endDate, LocalTime endTime) {
        LocalDate startDateParse = LocalDate.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
        LocalDate endDateParse = LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth());

        if ((dateToCheck.isEqual(startDateParse)) || dateToCheck.isAfter(startDateParse) &&
                (dateToCheck.isEqual(endDateParse) || dateToCheck.isBefore(endDateParse))) {
            if ((timeToCheck.isAfter(startTime.minusNanos(1)) &&
                    timeToCheck.isBefore(endTime.plusNanos(1)))) {
                return true;
            }
            return false;
        }
        return false;
    }


    public Promotion validate(PromotionRequest promotionRequest, Long promotionId) {
        Promotion promotion;

        if (promotionId != 0) {
            promotion = promotionRepository.findById(promotionId).orElseThrow(() -> new ResourceNotFoundException("Promotion", "id", promotionId));

            if(!promotion.getStatus().equals(OfferStatus.INACTIVE)){
                throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Cannot update this Promotion!");
            }
            BeanUtils.copyProperties(promotionRequest, promotion, "location", "promotionType");

        } else {
            promotion = mapper.map(promotionRequest, Promotion.class);
        }

        if(promotionRequest.getStartDate().isAfter(promotionRequest.getEndDate())){
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Promotion have StartDate is greater than EndDate!");
        }
        Location location = locationRepository.findById(promotionRequest.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", promotionRequest.getLocationId()));
        promotion.setLocation(location);

        switch (promotionRequest.getPromotionType()) {
            case BILL -> handleBillPromotion(promotionRequest, promotion);
            case PEOPLE -> handlePeoplePromotion(promotionRequest, promotion);
            case TIME -> handleTimePromotion(promotionRequest, promotion);
        }

        validatePromotionFields(promotionRequest);

        return promotion;
    }

    private PromotionResponse mapToResponse(Promotion promotion){
        return mapper.map(promotion, PromotionResponse.class);
    }

    @Scheduled(fixedRate = 10000)
    public void handlePromotionActive() {
        List<Promotion> promotionsActive = promotionRepository.findPromotionInactive(LocalDateTime.now(), OfferStatus.INACTIVE);
        promotionsActive.forEach(promotion -> promotion.setStatus(OfferStatus.ACTIVE));
        promotionRepository.saveAll(promotionsActive);
    }

    @Scheduled(fixedRate = 10000)
    public void handlePromotionExpire() {
        List<Promotion> promotionsExpire = promotionRepository.findPromotionActive(LocalDateTime.now(), OfferStatus.ACTIVE);
        promotionsExpire.forEach(promotion -> promotion.setStatus(OfferStatus.EXPIRE));
        promotionRepository.saveAll(promotionsExpire);
    }

    private Specification<Promotion> specification(Map<String, Object> searchParams){
        List<Specification<Promotion>> specs = new ArrayList<>();

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
                case "title":
                    specs.add(GenericSpecification.fieldContains(key, (String) value));
                    break;
            }
        });

        return specs.stream().reduce(Specification.where(null), Specification::and);
    }

    private void handleBillPromotion(PromotionRequest promotionRequest, Promotion promotion) {
        if (promotionRequest.getMinBill() == null) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Minimum bill must be specified for a BILL promotion");
        }
        promotion.setMinBill(promotionRequest.getMinBill());
    }

    private void handlePeoplePromotion(PromotionRequest promotionRequest, Promotion promotion) {
        if (promotionRequest.getMinPeople() == null) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Minimum people must be specified for a PEOPLE promotion");
        }
        promotion.setMinPeople(promotionRequest.getMinPeople());
    }

    private void handleTimePromotion(PromotionRequest promotionRequest, Promotion promotion) {
        if (promotionRequest.getStartHourTime() == null || promotionRequest.getEndHourTime() == null) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Start and end times must be specified for a TIME promotion");
        }
        promotion.setStartHourTime(promotionRequest.getStartHourTime());
        promotion.setEndHourTime(promotionRequest.getEndHourTime());
    }

    private void validatePromotionFields(PromotionRequest promotionRequest) {
        if (promotionRequest.getDiscountValue() == null &&
                promotionRequest.getMaxDiscount() == null &&
                (promotionRequest.getFreeItem() == null || promotionRequest.getFreeItem().trim().isEmpty())) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST,
                    "At least one of the following fields must be provided: discountValue, maxDiscount, or freeItem");
        }
    }
}
