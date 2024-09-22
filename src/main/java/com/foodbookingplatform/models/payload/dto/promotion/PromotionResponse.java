package com.foodbookingplatform.models.payload.dto.promotion;

import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.payload.dto.location.LocationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionResponse {
    private Long id;

    private String title;

    private float discountAmount;

    private String condition;

    private String description;

    private OfferStatus status;

    private String image;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocationResponse location;
}
