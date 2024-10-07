package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationAddResponse;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationLocationResponse;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationAddRequest;
import org.springframework.data.domain.Page;

import java.nio.file.AccessDeniedException;

public interface AdsRegistrationService {
    AdsRegistrationAddResponse addAdsRegistration(AdsRegistrationAddRequest adsRegistrationRequest) throws AccessDeniedException;
    AdsRegistrationAddResponse getAdsRegistration(Long id) throws AccessDeniedException;
    Page<AdsRegistrationLocationResponse> getAllAdsRegistrations(int pageNo, int pageSize, String sortBy, String sortDir);
    AdsRegistrationLocationResponse getAdsRegistrationsOfLocation(Long id) throws AccessDeniedException;
}
