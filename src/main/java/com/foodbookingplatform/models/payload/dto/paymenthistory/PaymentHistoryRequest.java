package com.foodbookingplatform.models.payload.dto.paymenthistory;

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
    private boolean status;
    private Long locationBookingId;
    private Long paymentMethodId;
}
