package com.foodbookingplatform.models.payload.dto.food;

import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.payload.dto.foodcategory.FoodCategoryResponse;
import com.foodbookingplatform.models.payload.dto.location.LocationResponseLazy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponse{

    private Long id;

    private String name;

    private float price;

    private String description;

    private EntityStatus status;

    private String image;

    private FoodCategoryResponse foodCategory;

    private LocationResponseLazy location;
}
