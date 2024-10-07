package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.*;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationAddResponse;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationLocationResponse;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationAddRequest;
import com.foodbookingplatform.models.payload.dto.adsregistration.AdsRegistrationResponse;
import com.foodbookingplatform.models.payload.dto.location.LocationResponseLazy;
import com.foodbookingplatform.repositories.AdsRegistrationRepository;
import com.foodbookingplatform.repositories.AdsRepository;
import com.foodbookingplatform.repositories.LocationRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.AdsRegistrationService;
import com.foodbookingplatform.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdsRegistrationServiceImpl implements AdsRegistrationService {
    private final AdsRegistrationRepository adsRegistrationRepository;
    private final LocationRepository locationRepository;
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public AdsRegistrationAddResponse addAdsRegistration(AdsRegistrationAddRequest adsRegistrationRequest) throws AccessDeniedException {
        Location location = locationRepository.findById(adsRegistrationRequest.getLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Location", "id", adsRegistrationRequest.getLocationId()));

        boolean isAuthorize = SecurityUtils.isAuthorizeLocation(location.getId(), userRepository);
        if (!isAuthorize) {
            throw new AccessDeniedException("You do not have permission to access promotions for this location.");
        }

        Ads ads = adsRepository.findById(adsRegistrationRequest.getAdsId())
                .orElseThrow(() -> new ResourceNotFoundException("Ads", "id", adsRegistrationRequest.getAdsId()));

        AdsRegistration adsRegistration = adsRegistrationRepository.findByLocationIdAndAdsIdAndStatus(location.getId(), ads.getId(), OfferStatus.ACTIVE);

        if(adsRegistration != null){
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "This location has been registration this ads!");
        }else{
            adsRegistration = new AdsRegistration();
            adsRegistration.setRegistrationDate(LocalDateTime.now());
            adsRegistration.setExpireDate(LocalDateTime.now().plusDays(ads.getDuration()));
            adsRegistration.setAds(ads);
            adsRegistration.setLocation(location);

            //handle Ads Type
            switch (ads.getType()){
                case AREA -> handleAreaAd(location, ads);
                case BANNER -> handleBannerAd(location, ads);
                case FLASH_SALE -> handleFlashSaleAd(location, ads);
            }
        }

        locationRepository.save(location);

        return mapper.map(adsRegistrationRepository.save(adsRegistration), AdsRegistrationAddResponse.class);
    }

    @Override
    public AdsRegistrationAddResponse getAdsRegistration(Long id) throws AccessDeniedException {
        AdsRegistration adsRegistration = adsRegistrationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AdsRegistration", "id", id));

        boolean isAuthorize = SecurityUtils.isAuthorizeLocation(adsRegistration.getLocation().getId(), userRepository);
        if (!isAuthorize) {
            throw new AccessDeniedException("You do not have permission to access promotions for this location.");
        }
        return mapper.map(adsRegistration, AdsRegistrationAddResponse.class);
    }

    @Override
    public Page<AdsRegistrationLocationResponse> getAllAdsRegistrations(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Location> locationPage = locationRepository.findAll(pageable);
        return locationPage.map(this::mapToResponse);
    }

    @Override
    public AdsRegistrationLocationResponse getAdsRegistrationsOfLocation(Long id) throws AccessDeniedException {
        boolean isAuthorize = SecurityUtils.isAuthorizeLocation(id, userRepository);
        if (!isAuthorize) {
            throw new AccessDeniedException("You do not have permission to access promotions for this location.");
        }

        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
        return mapToResponse(location);
    }

    private AdsRegistrationLocationResponse mapToResponse(Location location){
        List<AdsRegistration> adsRegistrationList = adsRegistrationRepository.findByLocation_Id(location.getId());

        AdsRegistrationLocationResponse response = new AdsRegistrationLocationResponse();
        response.setLocation(mapper.map(location, LocationResponseLazy.class));
        response.setAdsResponses(adsRegistrationList.stream().map(adsRegistration -> mapper.map(adsRegistration, AdsRegistrationResponse.class)).toList());

        return response;
    }

    // Handle Ads AREA
    private void handleAreaAd(Location location, Ads ads) {
        int currentSuggestCount = location.getOnSuggest();
        switch (ads.getLevel()) {
            case 1 -> location.setOnSuggest(currentSuggestCount + 1);
            case 2 -> location.setOnSuggest(currentSuggestCount + 2);
            case 3 -> location.setOnSuggest(currentSuggestCount + 3);
            default -> throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Invalid ad level for AREA.");
        }
    }

    // Handle Ads BANNER
    private void handleBannerAd(Location location, Ads ads) {
        int currentBannerCount = location.getOnBanner();
        switch (ads.getLevel()) {
            case 1 -> location.setOnBanner(currentBannerCount + 1);
            case 2 -> location.setOnBanner(currentBannerCount + 2);
            case 3 -> location.setOnBanner(currentBannerCount + 3);
            default -> throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Invalid ad level for BANNER.");
        }
    }

    // Handle Ads FLASH_SALE
    private void handleFlashSaleAd(Location location, Ads ads) {
        int currentFlashSaleCount = location.getOnSale();
        switch (ads.getLevel()) {
            case 1 -> location.setOnSale(currentFlashSaleCount + 1);
            case 2 -> location.setOnSale(currentFlashSaleCount + 2);
            case 3 -> location.setOnSale(currentFlashSaleCount + 3);
            default -> throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Invalid ad level for FLASH_SALE.");
        }
    }
}
