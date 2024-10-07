package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.FoodCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
    Page<FoodCategory> findFoodCategoriesByNameContainingIgnoreCase(String searchText, Pageable pageable);
}
