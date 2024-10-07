package com.foodbookingplatform.models.payload.dto.ads;

import com.foodbookingplatform.models.enums.AdsType;
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

    @NotNull(message = "Ad's type cannot be blank")
    private AdsType type;

    @NotNull(message = "Ad's level cannot be blank")
    @Min(value = 1, message = "Ad's level min is 1 and max is 3")
    @Max(value = 3, message = "Ad's level min is 1 and max is 3")
    private int level;

    @NotBlank(message = "Ad's name cannot be blank")
    @Size(min = 2, message = "Ad's name must have at least 2 characters")
    private String image;

    @NotNull(message = "Ad's duration cannot be null")
    @Min(value = 1, message = "Ad's duration must be at least 1 day")
    private int duration;
}
