package com.foodbookingplatform.models.payload.dto.locationbooking;

import com.foodbookingplatform.models.entities.*;
import com.foodbookingplatform.models.enums.LocationBookingStatus;
import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationBookingResponse {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private Float amount;

    private LocalDate bookingDate;

    private LocalTime bookingTime;

    private Integer numberOfAdult;

    private Integer numberOfChildren;

    private LocationBookingStatus status;

    private List<FoodBookingResponse> foodBookings;
}
