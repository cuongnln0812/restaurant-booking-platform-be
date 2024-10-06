package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.FoodBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodBookingRepository extends JpaRepository<FoodBooking, Long> {
}
