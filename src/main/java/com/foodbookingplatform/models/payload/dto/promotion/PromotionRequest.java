package com.foodbookingplatform.models.payload.dto.promotion;

import com.foodbookingplatform.models.constants.AppConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime startDate;

    @NotNull(message = "Promotion's EndDate cannot be null")
    @FutureOrPresent(message = "EndDate cannot be in the past")
    private LocalDateTime endDate;

    @NotEmpty(message = "Promotion type cannot be blank")
    @Pattern(regexp = AppConstants.PROMOTION_TYPE_REGEX, message = "Gender include: BILL, PEOPLE, TIME")
    @Size(min = 2, message = "Promotion type must have at least 2 characters")
    private String promotionType;

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

    private LocalDateTime startHourTime;

    private LocalDateTime endHourTime;

    @NotNull(message = "LocationId cannot be null")
    private Long locationId;
}
