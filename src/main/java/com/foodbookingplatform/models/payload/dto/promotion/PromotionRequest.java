package com.foodbookingplatform.models.payload.dto.promotion;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "Promotion's discount amount cannot be null")
    private float discountAmount;

    @NotBlank(message = "Promotion's condition cannot be blank")
    @Size(min = 2, message = "Promotion's condition must have at least 2 characters")
    private String condition;

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
    @FutureOrPresent(message = "StartDate cannot be in the past")
    private LocalDateTime endDate;

    @NotNull(message = "LocationId cannot be null")
    private Long locationId;
}
