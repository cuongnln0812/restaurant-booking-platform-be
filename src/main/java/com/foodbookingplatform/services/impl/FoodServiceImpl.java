package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Brand;
import com.foodbookingplatform.models.entities.Food;
import com.foodbookingplatform.models.entities.FoodCategory;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.brand.BrandResponse;
import com.foodbookingplatform.models.payload.dto.food.FoodRequest;
import com.foodbookingplatform.models.payload.dto.food.FoodResponse;
import com.foodbookingplatform.repositories.FoodCategoryRepository;
import com.foodbookingplatform.repositories.FoodRepository;
import com.foodbookingplatform.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final ModelMapper mapper;

    @Override
    public FoodResponse addFood(FoodRequest foodRequest) {
        Food food = mapper.map(foodRequest, Food.class);
        FoodCategory category = foodCategoryRepository.findById(foodRequest.getFoodCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category", "id", foodRequest.getFoodCategoryId()));
        food.setFoodCategory(category);
        Food savedFood = foodRepository.save(food);
        return mapper.map(savedFood, FoodResponse.class);
    }

    @Override
    public FoodResponse getFood(Long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "id", id));
        return mapper.map(food, FoodResponse.class);
    }

    @Override
    public List<FoodResponse> getAllFoods(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Food> foodPage = foodRepository.findAll(pageable);
        List<Food> foods = foodPage.getContent();
        return foods.stream().map(food -> mapper.map(food, FoodResponse.class)).toList();
    }

    @Override
    public List<FoodResponse> searchFoods(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Food> foodPage = foodRepository.findAll(pageable);
        List<Food> foods = foodPage.getContent();
        return foods.stream().map(food -> mapper.map(food, FoodResponse.class)).toList();
    }

    @Override
    public FoodResponse updateFood(FoodRequest foodRequest) {
        Food brand = foodRepository.findById(foodRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Food", "id", foodRequest.getId()));
        if (brand != null) {
            Food updatedFood = mapper.map(foodRequest, Food.class);
            FoodCategory category = foodCategoryRepository.findById(foodRequest.getFoodCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category", "id", foodRequest.getFoodCategoryId()));
            updatedFood.setFoodCategory(category);
            return mapper.map(foodRepository.save(updatedFood), FoodResponse.class);
        }
        return null;
    }

    @Override
    public void deleteFood(long id) {
        Food food = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "id", id));
        if (food != null) {
            foodRepository.delete(food);
        }
    }
}
