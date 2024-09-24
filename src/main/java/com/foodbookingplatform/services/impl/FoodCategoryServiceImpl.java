package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.FoodCategory;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.foodcategory.FoodCategoryRequest;
import com.foodbookingplatform.models.payload.dto.foodcategory.FoodCategoryResponse;
import com.foodbookingplatform.repositories.FoodCategoryRepository;
import com.foodbookingplatform.services.FoodCategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCategoryServiceImpl extends BaseServiceImpl<FoodCategory, FoodCategoryRequest, FoodCategoryResponse> implements FoodCategoryService {
    private final FoodCategoryRepository foodCategoryRepository;
    private final ModelMapper mapper;

    public FoodCategoryServiceImpl(FoodCategoryRepository foodCategoryRepository, ModelMapper modelMapper) {
        super(foodCategoryRepository, modelMapper, FoodCategory.class, FoodCategoryRequest.class, FoodCategoryResponse.class);
        this.foodCategoryRepository = foodCategoryRepository;
        this.mapper = modelMapper;
    }

    @Override
    public List<FoodCategoryResponse> search(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<FoodCategory> foodCategoriesPage = foodCategoryRepository.findFoodCategoriesByNameContainingIgnoreCase(searchText, pageable);
        List<FoodCategory> foodCategories = foodCategoriesPage.getContent();
        return foodCategories.stream().map(food -> mapper.map(food, FoodCategoryResponse.class)).toList();
    }

    @Override
    public FoodCategoryResponse update(FoodCategoryRequest foodCategoryRequest) {
        FoodCategory foodCategory = foodCategoryRepository.findById(foodCategoryRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("FoodCategory", "id", foodCategoryRequest.getId()));
        if (foodCategory != null) {
            foodCategory.setName(foodCategoryRequest.getName());
            foodCategory.setImage(foodCategoryRequest.getImage());
            return mapper.map(foodCategoryRepository.save(foodCategory), FoodCategoryResponse.class);
        }
        return null;
    }
}
