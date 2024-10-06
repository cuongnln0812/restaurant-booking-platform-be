package com.foodbookingplatform.models.payload.dto.ads;

import com.foodbookingplatform.models.constants.AppConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdsRequest {
    private Long id;

    @NotBlank(message = "Ad's name cannot be blank")
    @Size(min = 2, message = "Ad's name must have at least 2 characters")
    private String name;

    @NotNull(message = "Ad's price cannot be null")
    @Min(value = 10000, message = "Ad's price must be at least 10.000VND")
    private float price;

    @NotBlank(message = "Ad's name cannot be blank")
    @Size(min = 2, message = "Ad's name must have at least 2 characters")
    private String description;

    @NotEmpty(message = "Ad's type cannot be blank")
    @Pattern(regexp = AppConstants.ADS_TYPE_REGEX, message = "Ad's type include: AREA, FLASH_SALE, BANNER")
    @Size(min = 2, message = "Ad's type must have at least 2 characters")
    private String type;

    @NotBlank(message = "Ad's name cannot be blank")
    @Size(min = 2, message = "Ad's name must have at least 2 characters")
    private String image;

    @NotNull(message = "Ad's duration cannot be null")
    @Min(value = 1, message = "Ad's duration must be at least 1 hour")
    private int duration;
}
