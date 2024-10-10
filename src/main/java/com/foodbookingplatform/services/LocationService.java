package com.foodbookingplatform.services;

import com.foodbookingplatform.models.enums.AdsType;
import com.foodbookingplatform.models.payload.dto.location.LocationRequest;
import com.foodbookingplatform.models.payload.dto.location.LocationResponse;
import com.foodbookingplatform.models.payload.dto.location.LocationResponseLazy;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface LocationService {
    LocationResponse addLocation(LocationRequest locationRequest);
    LocationResponse getLocation(Long id);
    Page<LocationResponseLazy> getAllLocations(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<LocationResponseLazy> searchAllLocations(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams, double latitude, double longitude, boolean searchNearBy);
    LocationResponse updateLocation(LocationRequest locationRequest);
    void deleteLocation(long id);

    //Ads Registration
    Page<LocationResponseLazy> getLocationsWithBannerAds(int page, int size, AdsType adsType);
}
