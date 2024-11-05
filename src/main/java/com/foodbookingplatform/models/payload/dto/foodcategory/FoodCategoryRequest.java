package com.foodbookingplatform.models.payload.dto.foodcategory;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodCategoryRequest {
    private Long id;

    @NotEmpty(message = "Food category's image cannot be blank")
    private String image;

    @NotEmpty(message = "Food category's name cannot be blank")
    private String name;

    private EntityStatus status;
}
