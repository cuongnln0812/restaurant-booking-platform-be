package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.location.LocationRequest;
import com.foodbookingplatform.models.payload.dto.location.LocationResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface LocationService {
    LocationResponse addLocation(LocationRequest locationRequest);
    LocationResponse getLocation(Long id);
    Page<LocationResponse> getAllLocations(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<LocationResponse> searchAllLocations(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams);
    LocationResponse updateLocation(LocationRequest locationRequest);
    void deleteLocation(long id);
}
