package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.category.CategoryRequest;
import com.foodbookingplatform.models.payload.dto.category.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse addCategory(CategoryRequest categoryRequest);
    CategoryResponse getCategory(Long id);
    List<CategoryResponse> getAllCategories(int pageNo, int pageSize, String sortBy, String sortDir);
    List<CategoryResponse> searchCategories(int pageNo, int pageSize, String sortBy, String sortDir, String searchText);
    CategoryResponse updateCategory(CategoryRequest categoryRequest);
    void deleteCategory(long id);
}
