package com.foodbookingplatform.models.payload.dto.locationbooking;

import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationBookingRequest {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private LocalDate bookingDate;

    private LocalTime bookingTime;

    private Integer numberOfAdult = 0;

    private Integer numberOfChildren = 0;

    private Long locationId;

    private Long voucherId;

    private Long promotionId;

    private List<FoodBookingRequest> foodBookings;
}
