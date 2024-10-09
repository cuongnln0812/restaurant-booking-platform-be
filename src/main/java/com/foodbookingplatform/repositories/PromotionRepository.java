package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Promotion;
import com.foodbookingplatform.models.enums.OfferStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long>, JpaSpecificationExecutor<Promotion> {
    @Query("SELECT p FROM Promotion p WHERE ((:now > p.startDate) and p.status = :status)")
    List<Promotion> findPromotionInactive(@Param("now") LocalDateTime now,@Param("status") OfferStatus status);

    @Query("SELECT p FROM Promotion p WHERE ((:now > p.endDate) and p.status = :status)")
    List<Promotion> findPromotionActive(@Param("now")LocalDateTime now,@Param("status") OfferStatus status);

    Page<Promotion> getPromotionByLocation_Id(Long id, Pageable pageable);

    List<Promotion> findAllByLocationIdAndStatus(Long locationId, OfferStatus status);
}
