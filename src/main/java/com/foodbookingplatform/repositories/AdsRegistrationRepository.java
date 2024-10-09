package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.AdsRegistration;
import com.foodbookingplatform.models.enums.AdsType;
import com.foodbookingplatform.models.enums.OfferStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AdsRegistrationRepository extends JpaRepository<AdsRegistration, Long> {
    List<AdsRegistration> findByLocation_Id(Long id);
    List<AdsRegistration> findByAds_TypeAndStatus(AdsType type, OfferStatus status);
    AdsRegistration findByLocation_IdAndAds_IdAndStatus(Long locationId, Long adsId, OfferStatus status);
//    @Query("SELECT adsregis FROM AdsRegistration adsregis WHERE ((:now > adsregis.expireDate) and adsregis.status = :status)")
    List<AdsRegistration> findByExpireDateBeforeAndStatus(LocalDateTime now, OfferStatus status);
}
