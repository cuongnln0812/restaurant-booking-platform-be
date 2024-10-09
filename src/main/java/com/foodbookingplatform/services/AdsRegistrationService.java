package com.foodbookingplatform.services;

import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationAddEditResponse;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationLocationResponse;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationAddRequest;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationResponse;
import org.springframework.data.domain.Page;

import java.nio.file.AccessDeniedException;

public interface AdsRegistrationService {
    AdsRegistrationAddEditResponse addAdsRegistration(AdsRegistrationAddRequest adsRegistrationRequest) throws AccessDeniedException;
    AdsRegistrationResponse getAdsRegistration(Long id) throws AccessDeniedException;
    Page<AdsRegistrationLocationResponse> getAllAdsRegistrations(int pageNo, int pageSize, String sortBy, String sortDir);
    AdsRegistrationLocationResponse getAdsRegistrationsOfLocation(Long locationId) throws AccessDeniedException;
    AdsRegistrationAddEditResponse updateAdsRegistrationOfLocation(Long id, OfferStatus offerStatus) throws AccessDeniedException;
    void deleteAdsRegistrationOfLocation(Long id) throws AccessDeniedException;
}
