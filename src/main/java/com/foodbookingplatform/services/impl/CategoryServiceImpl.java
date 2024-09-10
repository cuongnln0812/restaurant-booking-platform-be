package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Brand;
import com.foodbookingplatform.models.entities.Category;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.brand.BrandResponse;
import com.foodbookingplatform.models.payload.dto.category.CategoryRequest;
import com.foodbookingplatform.models.payload.dto.category.CategoryResponse;
import com.foodbookingplatform.repositories.BrandRepository;
import com.foodbookingplatform.repositories.CategoryRepository;
import com.foodbookingplatform.services.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository brandRepository;
    private final ModelMapper mapper;

    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = mapper.map(categoryRequest, Category.class);
        Category savedCategory = brandRepository.save(category);
        return mapper.map(savedCategory, CategoryResponse.class);
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        Category category = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        return mapper.map(category, CategoryResponse.class);
    }

    @Override
    public List<CategoryResponse> getAllCategories(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Category> categoryPage = brandRepository.findAll(pageable);
        List<Category> categories = categoryPage.getContent();
        return categories.stream().map(category -> mapper.map(category, CategoryResponse.class)).toList();
    }

    @Override
    public List<CategoryResponse> searchCategories(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Category> categoryPage = brandRepository.searchCategoryByCategoryNameContainingIgnoreCase(searchText, pageable);
        List<Category> categories = categoryPage.getContent();
        return categories.stream().map(category -> mapper.map(category, CategoryResponse.class)).toList();
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest categoryRequest) {
        Category category = brandRepository.findById(categoryRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryRequest.getId()));
        if (category != null) {
            Category updatedCategory = mapper.map(categoryRequest, Category.class);
            return mapper.map(brandRepository.save(updatedCategory), CategoryResponse.class);
        }
        return null;
    }

    @Override
    public void deleteCategory(long id) {
        Category category = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        if (category != null) {
            brandRepository.delete(category);
        }
    }
}
