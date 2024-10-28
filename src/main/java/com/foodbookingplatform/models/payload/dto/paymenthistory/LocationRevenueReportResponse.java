package com.foodbookingplatform.models.payload.dto.paymenthistory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ntig
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationRevenueReportResponse {
    private Long id;
    private String locationName;
    private String locationPhoneNumber;
    private int numberOfBookingsInMonth;
    private double locationRevenueInMonth;
    private double revenueBroughtForSystemInMonth;
}
