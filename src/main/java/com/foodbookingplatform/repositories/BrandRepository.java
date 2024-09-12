package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Page<Brand> searchBrandByNameContainingIgnoreCase(String searchText, Pageable pageable);
}

