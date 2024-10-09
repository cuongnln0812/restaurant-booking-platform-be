package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Promotion;
import com.foodbookingplatform.models.enums.OfferStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long>, JpaSpecificationExecutor<Promotion> {
    List<Promotion> findByStartDateBeforeAndStatus(LocalDateTime now, OfferStatus status);

    List<Promotion> findByEndDateBeforeAndStatus(LocalDateTime now, OfferStatus status);

    Page<Promotion> getPromotionByLocation_Id(Long id, Pageable pageable);
}
