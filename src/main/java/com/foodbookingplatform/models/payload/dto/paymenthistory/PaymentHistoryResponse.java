package com.foodbookingplatform.models.payload.dto.paymenthistory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentHistoryResponse {
    private Long id;
    private float totalAmount;
    private boolean status;
    private Long locationBookingId;
    private Long paymentMethodId;
    private LocalDateTime createdDate;
}
