package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Ads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdsRepository extends JpaRepository<Ads, Long> {
    Page<Ads> findAdsByNameContainingIgnoreCase(String searchText, Pageable pageable);
}
