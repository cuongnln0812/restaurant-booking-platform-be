package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.food.FoodRequest;
import com.foodbookingplatform.models.payload.dto.food.FoodResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FoodService {
    FoodResponse addFood(FoodRequest brandRequest);
    FoodResponse getFood(Long id);
    List<FoodResponse> getAllFoods(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<FoodResponse> getAllFoodsByLocation(int pageNo, int pageSize, String sortBy, String sortDir, Long locationId);
    List<FoodResponse> searchFoods(int pageNo, int pageSize, String sortBy, String sortDir, String searchText);
    FoodResponse updateFood(FoodRequest brandRequest);
    void deleteFood(long id);
}
