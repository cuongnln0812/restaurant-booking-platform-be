package com.foodbookingplatform.models.payload.dto.paymenthistory;

import com.foodbookingplatform.models.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentHistoryRequest {
    private Long id;
    private float totalAmount;
    private PaymentStatus status;
    private Long locationBookingId;
    private Long paymentMethodId;
}
