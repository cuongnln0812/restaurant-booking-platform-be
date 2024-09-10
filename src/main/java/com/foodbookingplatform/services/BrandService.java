package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.brand.BrandRequest;
import com.foodbookingplatform.models.payload.dto.brand.BrandResponse;

import java.util.List;

public interface BrandService {
    BrandResponse addBrand(BrandRequest brandRequest);
    BrandResponse getBrand(Long id);
    List<BrandResponse> getAllBrands(int pageNo, int pageSize, String sortBy, String sortDir);
    List<BrandResponse> searchBrands(int pageNo, int pageSize, String sortBy, String sortDir, String searchText);
    BrandResponse updateBrand(BrandRequest brandRequest);
    void deleteBrand(long id);
}

