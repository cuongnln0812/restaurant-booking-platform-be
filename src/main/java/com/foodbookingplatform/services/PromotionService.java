package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.promotion.PromotionRequest;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface PromotionService {
    PromotionResponse addPromotion(PromotionRequest promotionRequest);
    PromotionResponse getPromotion(Long id);
    Page<PromotionResponse> getAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<PromotionResponse> searchAllPromotions(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams);
    PromotionResponse updatePromotion(PromotionRequest promotionRequest);
    void deletePromotion(long id);
}
