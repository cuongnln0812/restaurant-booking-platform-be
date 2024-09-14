package com.foodbookingplatform.models.payload.dto.foodCategory;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.validation.constraints.NotEmpty;

public class FoodCategoryResponse {
    private Long id;

    private String image;

    private String name;

    private EntityStatus status;
}
