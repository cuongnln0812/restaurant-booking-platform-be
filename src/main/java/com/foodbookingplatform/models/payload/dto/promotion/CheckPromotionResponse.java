package com.foodbookingplatform.models.payload.dto.promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckPromotionResponse {
    private Long promotionId;
    private Float discountedValue = 0.0f;
    private String freeItem = "None";
    private boolean isUsable = true;
}
