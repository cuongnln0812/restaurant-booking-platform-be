package com.foodbookingplatform.models.payload.dto.foodCategory;

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
public class FoodCategoryResponse {
    private Long id;

    private String image;

    private String name;

    private EntityStatus status;
}
