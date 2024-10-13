package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.enums.LocationBookingStatus;
import com.foodbookingplatform.models.payload.dto.address.AddressRequest;
import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingRequest;
import com.foodbookingplatform.models.payload.dto.locationbooking.LocationBookingResponse;
import com.foodbookingplatform.services.LocationBookingService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/location-bookings")
@SecurityRequirement(name = "Bear Authentication")
@RequiredArgsConstructor
public class LocationBookingController {
    
    private final LocationBookingService locationBookingService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<LocationBookingResponse>> getAllBooking(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "startDate", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "startTime", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDate startTime,
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDate endTime,
            @RequestParam(value = "startNumOfGuest", required = false) Integer startNumOfGuest,
            @RequestParam(value = "endNumOfGuest", required = false) Integer endNumOfGuest,
            @RequestParam(value = "status", required = false) List<LocationBookingStatus> status,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "phone", required = false) Long phone
    ) {
        Map<String, Object> keyword = new HashMap<>();

        if (status != null && !status.isEmpty()) keyword.put("status", status);
        if (startDate != null) keyword.put("startDate", startDate);
        if (endDate != null) keyword.put("endDate", endDate);
        if (startTime != null) keyword.put("startTime", startTime);
        if (endTime != null) keyword.put("endTime", endTime);
        if (startNumOfGuest != null) keyword.put("startNumOfGuest", startNumOfGuest);
        if (endNumOfGuest != null) keyword.put("endNumOfGuest", endNumOfGuest);
        if (name != null) keyword.put("name", name);
        if (address != null) keyword.put("address", address);
        if (phone != null) keyword.put("phone", phone);

        return ResponseEntity.ok(locationBookingService.getAllBooking(pageNo, pageSize, sortBy, sortDir, keyword));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('LOCATION_ADMIN')")
    @GetMapping("location/{locationId}")
    public ResponseEntity<Page<LocationBookingResponse>> getAllBookingByLocation(
            @PathVariable(name = "locationId") Long locationId,
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "startDate", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "startTime", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDate startTime,
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDate endTime,
            @RequestParam(value = "startNumOfGuest", required = false) Integer startNumOfGuest,
            @RequestParam(value = "endNumOfGuest", required = false) Integer endNumOfGuest,
            @RequestParam(value = "status", required = false) List<LocationBookingStatus> status,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "phone", required = false) Long phone
    ) throws AccessDeniedException {
        Map<String, Object> keyword = new HashMap<>();

        if (status != null && !status.isEmpty()) keyword.put("status", status);
        if (startDate != null) keyword.put("startDate", startDate);
        if (endDate != null) keyword.put("endDate", endDate);
        if (startTime != null) keyword.put("startTime", startTime);
        if (endTime != null) keyword.put("endTime", endTime);
        if (startNumOfGuest != null) keyword.put("startNumOfGuest", startNumOfGuest);
        if (endNumOfGuest != null) keyword.put("endNumOfGuest", endNumOfGuest);
        if (name != null) keyword.put("name", name);
        if (address != null) keyword.put("address", address);
        if (phone != null) keyword.put("phone", phone);

        return ResponseEntity.ok(locationBookingService.getAllBookingByLocation(locationId, pageNo, pageSize, sortBy, sortDir, keyword));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("user")
    public ResponseEntity<Page<LocationBookingResponse>> getAllBookingByUser(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "startDate", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "startTime", required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDate startTime,
            @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDate endTime,
            @RequestParam(value = "startNumOfGuest", required = false) Integer startNumOfGuest,
            @RequestParam(value = "endNumOfGuest", required = false) Integer endNumOfGuest,
            @RequestParam(value = "status", required = false) List<LocationBookingStatus> status,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "phone", required = false) Long phone
    ) {
        Map<String, Object> keyword = new HashMap<>();

        if (status != null && !status.isEmpty()) keyword.put("status", status);
        if (startDate != null) keyword.put("startDate", startDate);
        if (endDate != null) keyword.put("endDate", endDate);
        if (startTime != null) keyword.put("startTime", startTime);
        if (endTime != null) keyword.put("endTime", endTime);
        if (startNumOfGuest != null) keyword.put("startNumOfGuest", startNumOfGuest);
        if (endNumOfGuest != null) keyword.put("endNumOfGuest", endNumOfGuest);
        if (name != null) keyword.put("name", name);
        if (address != null) keyword.put("address", address);
        if (phone != null) keyword.put("phone", phone);

        return ResponseEntity.ok(locationBookingService.getAllBookingByUser(pageNo, pageSize, sortBy, sortDir, keyword));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasAnyRole('USER', 'LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<LocationBookingResponse> getLocationBookingDetail(@PathVariable Long id) {
        return ResponseEntity.ok(locationBookingService.getLocationBookingDetail(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @PostMapping()
    public ResponseEntity<LocationBookingResponse> createLocationBooking(@RequestBody @Valid LocationBookingRequest request){
        return ResponseEntity.ok(locationBookingService.createLocationBooking(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasAnyRole('USER', 'LOCATION_ADMIN')")
    @PutMapping("cancel/{id}")
    public ResponseEntity<LocationBookingResponse> cancelLocationBooking(@PathVariable Long id) {
        return ResponseEntity.ok(locationBookingService.cancelLocationBooking(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('LOCATION_ADMIN')")
    @PutMapping("approve/{id}")
    public ResponseEntity<LocationBookingResponse> approveLocationBooking(@PathVariable Long id) {
        return ResponseEntity.ok(locationBookingService.approveLocationBooking(id));
    }
    
}
