package com.foodbookingplatform.models.payload.dto.foodbooking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodBookingRequest {

    private Long foodId;

    private Integer quantity;
}
