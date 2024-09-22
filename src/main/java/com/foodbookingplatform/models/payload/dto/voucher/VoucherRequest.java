package com.foodbookingplatform.models.payload.dto.voucher;

import com.foodbookingplatform.models.enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoucherRequest {
    private Long id;

    private String code;

    private String name;

    private int quantity;

    private int quantityUse;

    private float discount;

    private int maxDiscountAmount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private float minOrderAmount;
}
