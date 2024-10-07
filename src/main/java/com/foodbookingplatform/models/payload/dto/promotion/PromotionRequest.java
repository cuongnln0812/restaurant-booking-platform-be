package com.foodbookingplatform.models.payload.dto.promotion;

import com.foodbookingplatform.models.enums.PromotionType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionRequest {
    private Long id;

    @NotBlank(message = "Location's title cannot be blank")
    @Size(min = 2, message = "Location's title must have at least 2 characters")
    private String title;

    @NotBlank(message = "Promotion's description cannot be blank")
    @Size(min = 2, message = "Promotion's description must have at least 2 characters")
    private String description;

    @NotBlank(message = "Promotion's image cannot be blank")
    @Size(min = 2, message = "Promotion's image must have at least 2 characters")
    private String image;

    @NotNull(message = "Promotion's StartDate cannot be null")
    @FutureOrPresent(message = "StartDate cannot be in the past")
    private LocalDate startDate;

    @NotNull(message = "Promotion's EndDate cannot be null")
    @FutureOrPresent(message = "EndDate cannot be in the past")
    private LocalDate endDate;

    @NotNull(message = "Promotion type cannot be blank")
    private PromotionType promotionType;

    @Min(value = 10000, message = "Promotion's discount must be at least 10.000VND")
    private Double discountValue;

    @Min(value = 10000, message = "Promotion's max discount must be at least 10.000VND")
    private Double maxDiscount;

    @Size(min = 2, message = "Promotion's image must have at least 2 characters")
    private String freeItem;

    @Min(value = 10000, message = "Promotion's min bill must be at least 10.000VND")
    private Double minBill;

    @Min(value = 1, message = "Promotion's min people must be at least 1")
    private Integer minPeople;

    private LocalTime startHourTime;

    private LocalTime endHourTime;

    @NotNull(message = "LocationId cannot be null")
    private Long locationId;
}
