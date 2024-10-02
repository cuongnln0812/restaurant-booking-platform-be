package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingRequest;
import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingResponse;

public interface LocationBookingService {

    LocationBookingResponse createLocationBooking(LocationBookingRequest request);
    LocationBookingResponse cancelLocationBooking(LocationBookingRequest request);
    LocationBookingResponse approveLocationBooking(LocationBookingRequest request);
}
