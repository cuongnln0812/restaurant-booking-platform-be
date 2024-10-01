package com.foodbookingplatform.models.payload.dto.packages;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PackageRequest {
    private Long id;

    @NotBlank(message = "Package's name cannot be blank")
    @Size(min = 2, message = "Package's name must have at least 2 characters")
    private String name;

    @NotNull(message = "Package's price cannot be null")
    @Min(value = 0, message = "Package's price must be at least 0")
    private float price;

    @NotBlank(message = "Package's name cannot be blank")
    @Size(min = 2, message = "Package's name must have at least 2 characters")
    private String description;

    @NotBlank(message = "Package's name cannot be blank")
    @Size(min = 2, message = "Package's name must have at least 2 characters")
    private String image;

    @NotNull(message = "Package's duration cannot be null")
    @Min(value = 0, message = "Package's duration must be at least 0")
    private int duration;
}
