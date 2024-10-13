package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Page<Food> searchFoodByNameContainingIgnoreCase(String searchText, Pageable pageable);
    Page<Food> getFoodByLocation_Id(Long locationId, Pageable pageable);
}
