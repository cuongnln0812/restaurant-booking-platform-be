package com.foodbookingplatform.services;

import com.foodbookingplatform.models.entities.FoodBooking;
import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingRequest;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionRequest;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface PromotionService {
    PromotionResponse addPromotion(PromotionRequest promotionRequest);
    PromotionResponse getPromotion(Long id);
    Page<PromotionResponse> getAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<PromotionResponse> searchAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams);
    PromotionResponse updatePromotion(PromotionRequest promotionRequest);
    void deletePromotion(long id);
    float applyPromotion(Long promotionId, float totalPrice, int numberOfPeople, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime);
}
