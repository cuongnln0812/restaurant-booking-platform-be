package com.foodbookingplatform.models.payload.dto.location;


import com.foodbookingplatform.models.constants.AppConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {
    private Long id;

    @NotBlank(message = "Location's name cannot be blank")
    @Size(min = 2, message = "Location's name must have at least 2 characters")
    private String name;

    @NotBlank(message = "Location's address cannot be blank")
    @Size(min = 2, message = "Location's address must have at least 2 characters")
    private String address;

    @NotBlank(message = "Location's phone cannot be blank")
    @Pattern(regexp = AppConstants.PHONE_REGEX, message = "Invalid phone number!")
    @Size(min = 2, message = "Location's phone must have at least 2 characters")
    private String phone;

    @NotNull(message = "Location's suggest cannot be null")
    private boolean suggest;

    @NotNull(message = "Location's sale cannot be null")
    private boolean sale;

    @NotBlank(message = "Location's latitude cannot be blank")
    @Size(min = 2, message = "Location's latitude must have at least 2 characters")
    private String latitude;

    @NotBlank(message = "Location's longitude cannot be blank")
    @Size(min = 2, message = "Location's longitude must have at least 2 characters")
    private String longitude;

    @NotNull(message = "Location's openingHours cannot be null")
    private LocalTime openingHours;

    @NotNull(message = "Location's closingHours cannot be null")
    private LocalTime closingHours;

    @NotBlank(message = "Location's description cannot be blank")
    @Size(min = 2, message = "Location's description must have at least 2 characters")
    private String description;

    @NotBlank(message = "Location's image cannot be blank")
    @Size(min = 2, message = "Location's image must have at least 2 characters")
    private String image;

    @NotNull(message = "UserId cannot be null")
    private Long userId;

    @NotNull(message = "BrandId cannot be null")
    private Long brandId;

    @NotNull(message = "BrandId cannot be null")
    private List<Long> categoryId;

    @NotNull(message = "BrandId cannot be null")
    private List<Long> tagId;
}
