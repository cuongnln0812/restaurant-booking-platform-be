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
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyRevenueResponse {
    private String month;
    private double totalRevenue;
}
