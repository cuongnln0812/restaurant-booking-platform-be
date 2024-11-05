package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.promotion.ApplyPromotionResponse;
import com.foodbookingplatform.models.payload.dto.promotion.CheckPromotionResponse;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionRequest;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionResponse;
import com.foodbookingplatform.models.payload.dto.uservoucher.ApplyUserVoucherResponse;
import org.springframework.data.domain.Page;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface PromotionService {
    PromotionResponse addPromotion(PromotionRequest promotionRequest);
    PromotionResponse getPromotion(Long id);
    Page<PromotionResponse> getAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<PromotionResponse> getAllPromotionsOfLocation(int pageNo, int pageSize, String sortBy, String sortDir, long id) throws AccessDeniedException;
    Page<PromotionResponse> searchAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams);
    PromotionResponse updatePromotion(PromotionRequest promotionRequest) throws AccessDeniedException;
    void deletePromotion(long id) throws AccessDeniedException;
    List<ApplyPromotionResponse> getUsablePromotionListOfLocation(Long locationId, Float totalPrice, Integer numberOfPeople,
                                                            LocalDate bookingDate, LocalTime bookingTime);
    CheckPromotionResponse applyPromotion(Long promotionId, Float totalPrice, Integer numberOfPeople, LocalDate bookingDate, LocalTime bookingTime);
}
