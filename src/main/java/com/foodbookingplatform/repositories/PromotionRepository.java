package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Promotion;
import com.foodbookingplatform.models.enums.OfferStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long>, JpaSpecificationExecutor<Promotion> {
    @Query("SELECT p FROM Promotion p WHERE ((:now > p.startDate) and p.status = :status)")
    List<Promotion> findPromotionInactive(LocalDateTime now, OfferStatus status);

    @Query("SELECT p FROM Promotion p WHERE ((:now > p.endDate) and p.status = :status)")
    List<Promotion> findPromotionActive(LocalDateTime now, OfferStatus status);
}
