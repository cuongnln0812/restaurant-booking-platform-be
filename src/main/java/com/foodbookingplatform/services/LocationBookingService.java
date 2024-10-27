package com.foodbookingplatform.services;

import com.foodbookingplatform.models.enums.LocationBookingStatus;
import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingRequest;
import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingResponse;
import org.springframework.data.domain.Page;

import java.nio.file.AccessDeniedException;
import java.util.Map;

public interface LocationBookingService {

    Page<LocationBookingResponse> getAllBooking(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword);
    Page<LocationBookingResponse> getAllBookingByLocation(Long locationId, int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword) throws AccessDeniedException;
    Page<LocationBookingResponse> getAllBookingByUser(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword);
    LocationBookingResponse createLocationBooking(LocationBookingRequest request);
    LocationBookingResponse cancelLocationBooking(Long bookingId);
    LocationBookingResponse approveLocationBooking(Long bookingId);
    LocationBookingResponse successLocationBooking(Long bookingId);
    LocationBookingResponse getLocationBookingDetail(Long bookingId);
    int countAllBookingsInSystem(LocationBookingStatus status, int month, int year);
}
