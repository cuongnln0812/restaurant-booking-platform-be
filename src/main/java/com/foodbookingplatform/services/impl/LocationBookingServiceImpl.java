package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingRequest;
import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingResponse;
import com.foodbookingplatform.repositories.LocationBookingRepository;
import com.foodbookingplatform.repositories.LocationRepository;
import com.foodbookingplatform.services.LocationBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationBookingServiceImpl implements LocationBookingService {

    private final LocationBookingRepository locationBookingRepository;

    @Override
    public LocationBookingResponse createLocationBooking(LocationBookingRequest request) {
        return null;
    }

    @Override
    public LocationBookingResponse cancelLocationBooking(LocationBookingRequest request) {
        return null;
    }

    @Override
    public LocationBookingResponse approveLocationBooking(LocationBookingRequest request) {
        return null;
    }
}
