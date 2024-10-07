package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.AdsRegistration;
import com.foodbookingplatform.models.enums.AdsType;
import com.foodbookingplatform.models.enums.OfferStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdsRegistrationRepository extends JpaRepository<AdsRegistration, Long> {
    List<AdsRegistration> findByLocation_Id(Long id);

//    @Query("SELECT adsregis FROM AdsRegistration adsregis JOIN Ads ads ON ads.id = adsregis.ads.id JOIN Location location ON location.id = adsregis.location.id WHERE (adsregis.status = :status) and (adsregis.location.id = :location_id) and (adsregis.ads.id = :ads_id)")
    Page<AdsRegistration> findByAds_TypeAndStatus(AdsType type, OfferStatus status, Pageable pageable);

    @Query("SELECT adsregis FROM AdsRegistration adsregis WHERE (adsregis.status = :status) and (adsregis.location.id = :location_id) and (adsregis.ads.id = :ads_id)")
    AdsRegistration findByLocationIdAndAdsIdAndStatus(@Param("location_id") Long locationId, @Param("ads_id") Long adsId, @Param("status") OfferStatus status);
}
