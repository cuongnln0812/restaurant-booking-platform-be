package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.payload.dto.foodCategory.FoodCategoryRequest;
import com.foodbookingplatform.models.payload.dto.foodCategory.FoodCategoryResponse;
import com.foodbookingplatform.services.FoodCategoryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-categories")
@RequiredArgsConstructor
public class FoodCategoryController {
    private final FoodCategoryService foodCategoryService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping
    public ResponseEntity<List<FoodCategoryResponse>> getAllCategories(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(foodCategoryService.getAll(pageNo, pageSize, sortBy, sortDir));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping("/search")
    public ResponseEntity<List<FoodCategoryResponse>> searchCategories(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(name = "keyword") String keyword
    ) {
        return ResponseEntity.ok(foodCategoryService.search(pageNo, pageSize, sortBy, sortDir, keyword));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping("{id}")
    public ResponseEntity<FoodCategoryResponse> getCategory(@PathVariable Long id) {
        FoodCategoryResponse foodCategoryResponse = foodCategoryService.get(id);
        return ResponseEntity.ok(foodCategoryResponse);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PostMapping
    public ResponseEntity<FoodCategoryResponse> addCategory(@RequestBody @Valid FoodCategoryRequest request) {
        return ResponseEntity.ok(foodCategoryService.add(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PutMapping
    public ResponseEntity<FoodCategoryResponse> updateCategory(@RequestBody @Valid FoodCategoryRequest request) {
        return ResponseEntity.ok(foodCategoryService.update(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        foodCategoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
