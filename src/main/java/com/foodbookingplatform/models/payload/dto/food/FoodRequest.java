package com.foodbookingplatform.models.payload.dto.food;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodRequest {
    private Long id;

    @NotEmpty(message = "Food's name cannot be blank")
    private String name;

    @Min(value = 1, message = "Food's price must be greater than 0")
    private float price;

    @NotEmpty(message = "Food's description cannot be blank")
    private String description;

    private EntityStatus status;

    @NotEmpty(message = "Food's image cannot be blank")
    private String image;

    private Long foodCategoryId;
}
