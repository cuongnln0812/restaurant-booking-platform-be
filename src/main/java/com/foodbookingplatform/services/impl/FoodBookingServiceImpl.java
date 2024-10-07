package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Food;
import com.foodbookingplatform.models.entities.FoodBooking;
import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.payload.dto.foodbooking.FoodBookingRequest;
import com.foodbookingplatform.repositories.FoodBookingRepository;
import com.foodbookingplatform.repositories.FoodRepository;
import com.foodbookingplatform.services.FoodBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FoodBookingServiceImpl implements FoodBookingService {

    private final FoodBookingRepository foodBookingRepository;

    @Override
    public List<FoodBooking> createFoodBooking(List<Food> foods, List<Integer> quantity, LocationBooking locationBooking) {
        List<FoodBooking> foodBookings = new ArrayList<>();

        for (int i = 0; i < foods.size(); i++) {
            FoodBooking foodBooking = new FoodBooking();
            foodBooking.setFood(foods.get(i));
            foodBooking.setQuantity(quantity.get(i));
            foodBooking.setAmount(quantity.get(i) * foods.get(i).getPrice());
            foodBooking.setPaymentDate(LocalDateTime.now());
            foodBooking.setLocationBooking(locationBooking);
            foodBookings.add(foodBooking); // Add to the list
        }

        // Save all the food bookings in bulk and return the saved list
        return foodBookingRepository.saveAll(foodBookings);
    }

}
