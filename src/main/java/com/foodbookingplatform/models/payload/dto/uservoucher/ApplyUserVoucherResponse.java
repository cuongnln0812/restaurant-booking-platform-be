package com.foodbookingplatform.models.payload.dto.uservoucher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplyUserVoucherResponse {
    private Long id;

    private String code;

    private String description;

    private Float discount;

    private Float minOrderAmount;

    private Integer maxDiscountAmount;

    private Integer quantityAvailable;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean isUsable = false;
}
