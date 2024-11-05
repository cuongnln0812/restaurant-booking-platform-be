package com.foodbookingplatform.services;

import com.foodbookingplatform.models.entities.Food;
import com.foodbookingplatform.models.entities.FoodBooking;
import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingRequest;
import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingResponse;

import java.util.List;

public interface FoodBookingService {
    List<FoodBooking> createFoodBooking(List<Food> foods, List<Integer> quantity, LocationBooking locationBooking);
}
