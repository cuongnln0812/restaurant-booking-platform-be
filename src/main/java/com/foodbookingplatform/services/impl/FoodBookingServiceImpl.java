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
    private final FoodRepository foodRepository;
    @Override
    public List<FoodBooking> createFoodBooking(List<FoodBookingRequest> requests, LocationBooking locationBooking) {
        List<FoodBooking> foodBookings = new ArrayList<>();

        for (FoodBookingRequest request : requests) {
            Food bookedFood = foodRepository.findById(request.getFoodId())
                    .orElseThrow(() -> new ResourceNotFoundException("Food", "id", request.getFoodId()));

            if (bookedFood.getStatus().equals(EntityStatus.ACTIVE)) {
                FoodBooking foodBooking = new FoodBooking();
                foodBooking.setFood(bookedFood);
                foodBooking.setQuantity(request.getQuantity());
                foodBooking.setAmount(request.getQuantity() * bookedFood.getPrice());
                foodBooking.setPaymentDate(LocalDateTime.now());
                foodBooking.setLocationBooking(locationBooking);

                foodBookings.add(foodBooking); // Add to the list
            } else {
                throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, bookedFood.getName() + " is not available to pre-order!");
            }
        }

        // Save all the food bookings in bulk and return the saved list
        return foodBookingRepository.saveAll(foodBookings);
    }

}
