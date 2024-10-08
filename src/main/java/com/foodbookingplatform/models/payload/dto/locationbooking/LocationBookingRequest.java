package com.foodbookingplatform.models.payload.dto.locationbooking;

import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingRequest;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.foodbookingplatform.models.constants.AppConstants.PHONE_REGEX;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationBookingRequest {
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Address must not be blank")
    private String address;

    @NotBlank(message = "Phone must not be blank")
    @Size(min = 10, max = 12, message = "Phone number must be between 10 and 12 digits")
    @Pattern(regexp = PHONE_REGEX)
    private String phone;

    @NotNull(message = "Name must not be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Booking date cannot be in the past")
    private LocalDate bookingDate;

    @NotNull(message = "Booking time must not be blank")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime bookingTime;

    @NotNull(message = "Number of adult should not be blank")
    @Min(value = 1, message = "There should be at least 1 adult to book")
    private Integer numberOfAdult = 0;

    @NotNull(message = "Number of adult should not be blank")
    @Min(value = 0, message = "Invalid number of children!")
    private Integer numberOfChildren = 0;

    @NotNull(message = "Location must not be blank")
    private Long locationId;

    private Long voucherId;

    private Long promotionId;

    private List<FoodBookingRequest> foodBookings;
}
