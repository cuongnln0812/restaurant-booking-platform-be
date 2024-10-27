package com.foodbookingplatform.models.payload.dto.paymenthistory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ntig
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecentPaymentResponse {
    private String userFullName;
    private String userEmail;
    private double paymentPrice;
}
