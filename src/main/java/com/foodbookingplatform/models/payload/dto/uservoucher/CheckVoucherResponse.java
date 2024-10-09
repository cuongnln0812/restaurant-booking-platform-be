package com.foodbookingplatform.models.payload.dto.uservoucher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckVoucherResponse {
    private Long voucherId;
    private Float discountedValue;
    private boolean isUsable = true;
}
