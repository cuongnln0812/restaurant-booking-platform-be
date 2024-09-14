package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
