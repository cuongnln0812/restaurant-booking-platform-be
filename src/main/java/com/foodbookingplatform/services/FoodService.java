package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.brand.BrandRequest;
import com.foodbookingplatform.models.payload.dto.brand.BrandResponse;
import com.foodbookingplatform.models.payload.dto.food.FoodRequest;
import com.foodbookingplatform.models.payload.dto.food.FoodResponse;

import java.util.List;

public interface FoodService {
    FoodResponse addFood(FoodRequest brandRequest);
    FoodResponse getFood(Long id);
    List<FoodResponse> getAllFoods(int pageNo, int pageSize, String sortBy, String sortDir);
    List<FoodResponse> searchFoods(int pageNo, int pageSize, String sortBy, String sortDir, String searchText);
    FoodResponse updateFood(FoodRequest brandRequest);
    void deleteFood(long id);
}
