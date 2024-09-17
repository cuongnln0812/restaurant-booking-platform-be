package com.foodbookingplatform.models.payload.dto.brand;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.validation.constraints.NotEmpty;
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
public class BrandRequest {
    private Long Id;
    @NotEmpty(message = "Brand's name cannot be blank")
    @Size(min = 2, message = "Brand's name must have at least 2 characters")
    private String name;
    private EntityStatus status;
    @NotEmpty(message = "Brand's image cannot be blank")
    @Size(min = 2, message = "Brand's image must have at least 2 characters")
    private String image;
}