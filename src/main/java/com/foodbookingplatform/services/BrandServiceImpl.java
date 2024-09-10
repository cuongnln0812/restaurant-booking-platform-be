package com.foodbookingplatform.services;

import com.foodbookingplatform.models.entities.Brand;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.brand.BrandRequest;
import com.foodbookingplatform.models.payload.dto.brand.BrandResponse;
import com.foodbookingplatform.repositories.BrandRepository;
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
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper mapper;

    @Override
    public BrandResponse addBrand(BrandRequest brandRequest) {
        Brand brand = mapper.map(brandRequest, Brand.class);
        Brand savedBrand = brandRepository.save(brand);
        return mapper.map(savedBrand, BrandResponse.class);
    }

    @Override
    public BrandResponse getBrand(Long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", "id", id));
        return mapper.map(brand, BrandResponse.class);
    }

    @Override
    public List<BrandResponse> getAllBrands(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Brand> brandPage = brandRepository.findAll(pageable);
        List<Brand> brands = brandPage.getContent();
        return brands.stream().map(brand -> mapper.map(brand, BrandResponse.class)).toList();
    }

    @Override
    public List<BrandResponse> searchBrands(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Brand> brandPage = brandRepository.searchBrandByBrandNameContainingIgnoreCase(searchText, pageable);
        List<Brand> brands = brandPage.getContent();
        return brands.stream().map(brand -> mapper.map(brand, BrandResponse.class)).toList();
    }

    @Override
    public BrandResponse updateBrand(BrandRequest brandRequest) {
        Brand brand = brandRepository.findById(brandRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Brand", "id", brandRequest.getId()));
        if (brand != null) {
            Brand updatedBrand = mapper.map(brandRequest, Brand.class);
            return mapper.map(brandRepository.save(updatedBrand), BrandResponse.class);
        }
        return null;
    }

    @Override
    public void deleteBrand(long id) {
        Brand brand = brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand", "id", id));
        if (brand != null) {
            brandRepository.delete(brand);
        }
    }
}

