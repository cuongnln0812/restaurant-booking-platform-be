package com.foodbookingplatform.models.payload.dto.foodbooking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodBookingResponse {
    private Long foodId;

    private String foodName;

    private Integer quantity;

    private Float amount;
}
