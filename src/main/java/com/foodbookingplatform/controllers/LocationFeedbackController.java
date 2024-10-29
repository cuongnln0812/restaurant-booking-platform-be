package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.payload.dto.feedback.LocationFeedbackRequest;
import com.foodbookingplatform.models.payload.dto.feedback.LocationFeedbackResponse;
import com.foodbookingplatform.services.LocationFeedbackService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/feedbacks")
@RequiredArgsConstructor
public class LocationFeedbackController {
    private final LocationFeedbackService feedbackService;

    @ApiResponse(responseCode = "201", description = "Http Status 201 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<LocationFeedbackResponse> createFeedback(@RequestBody @Valid LocationFeedbackRequest request) {
        return ResponseEntity.ok(feedbackService.createFeedback(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping
    public ResponseEntity<Page<LocationFeedbackResponse>> getAllFeedback(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "feedbackDateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate feedbackDateFrom,
            @RequestParam(value = "feedbackDateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate feedbackDateTo,
            @RequestParam(value = "minRating", required = false) Integer minRating,
            @RequestParam(value = "maxRating", required = false) Integer maxRating,
            @RequestParam(value = "userFullName", required = false) String userFullName,
            @RequestParam(value = "locationName", required = false) String locationName,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "numberOfGuestFrom", required = false) Integer numberOfGuestFrom,
            @RequestParam(value = "numberOfGuestTo", required = false) Integer numberOfGuestTo
    ) {
        Map<String, Object> filters = new HashMap<>();

        if (feedbackDateFrom != null) filters.put("feedbackDateFrom", feedbackDateFrom);
        if (feedbackDateTo != null) filters.put("feedbackDateTo", feedbackDateTo);
        if (minRating != null) filters.put("minRating", minRating);
        if (maxRating != null) filters.put("maxRating", maxRating);
        if (userFullName != null) filters.put("userFullName", userFullName);
        if (locationName != null) filters.put("locationName", locationName);
        if (content != null) filters.put("content", content);
        if (numberOfGuestFrom != null) filters.put("numberOfGuestFrom", numberOfGuestFrom);
        if (numberOfGuestTo != null) filters.put("numberOfGuestTo", numberOfGuestTo);

        return ResponseEntity.ok(feedbackService.getAllFeedback(pageNo, pageSize, sortBy, sortDir, filters));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping("location/{locationId}")
    public ResponseEntity<Page<LocationFeedbackResponse>> getAllFeedbackOfLocation(
            @PathVariable(name = "locationId") Long locationId,
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "feedbackDateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate feedbackDateFrom,
            @RequestParam(value = "feedbackDateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate feedbackDateTo,
            @RequestParam(value = "minRating", required = false) Integer minRating,
            @RequestParam(value = "maxRating", required = false) Integer maxRating,
            @RequestParam(value = "userFullName", required = false) String userFullName,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "numberOfGuestFrom", required = false) Integer numberOfGuestFrom,
            @RequestParam(value = "numberOfGuestTo", required = false) Integer numberOfGuestTo
    ) throws AccessDeniedException {
        Map<String, Object> filters = new HashMap<>();

        if (feedbackDateFrom != null) filters.put("feedbackDateFrom", feedbackDateFrom);
        if (feedbackDateTo != null) filters.put("feedbackDateTo", feedbackDateTo);
        if (minRating != null) filters.put("minRating", minRating);
        if (maxRating != null) filters.put("maxRating", maxRating);
        if (userFullName != null) filters.put("userFullName", userFullName);
        if (content != null) filters.put("content", content);
        if (numberOfGuestFrom != null) filters.put("numberOfGuestFrom", numberOfGuestFrom);
        if (numberOfGuestTo != null) filters.put("numberOfGuestTo", numberOfGuestTo);

        return ResponseEntity.ok(feedbackService.getAllFeedbackOfLocation( locationId, pageNo, pageSize, sortBy, sortDir, filters));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping("user")
    public ResponseEntity<Page<LocationFeedbackResponse>> getAllFeedbackOfUser(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "feedbackDateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate feedbackDateFrom,
            @RequestParam(value = "feedbackDateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate feedbackDateTo,
            @RequestParam(value = "minRating", required = false) Integer minRating,
            @RequestParam(value = "maxRating", required = false) Integer maxRating,
            @RequestParam(value = "locationName", required = false) String locationName,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "numberOfGuestFrom", required = false) Integer numberOfGuestFrom,
            @RequestParam(value = "numberOfGuestTo", required = false) Integer numberOfGuestTo
    ) {
        Map<String, Object> filters = new HashMap<>();

        if (feedbackDateFrom != null) filters.put("feedbackDateFrom", feedbackDateFrom);
        if (feedbackDateTo != null) filters.put("feedbackDateTo", feedbackDateTo);
        if (minRating != null) filters.put("minRating", minRating);
        if (maxRating != null) filters.put("maxRating", maxRating);
        if (locationName != null) filters.put("locationName", locationName);
        if (content != null) filters.put("content", content);
        if (numberOfGuestFrom != null) filters.put("numberOfGuestFrom", numberOfGuestFrom);
        if (numberOfGuestTo != null) filters.put("numberOfGuestTo", numberOfGuestTo);

        return ResponseEntity.ok(feedbackService.getAllFeedbackOfUser(pageNo, pageSize, sortBy, sortDir, filters));
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 OK")
    @GetMapping("{id}")
    public ResponseEntity<LocationFeedbackResponse> getFeedbackById(@PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.getFeedbackById(id));
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('USER')")
    @PutMapping()
    public ResponseEntity<LocationFeedbackResponse> updateFeedback(@RequestBody LocationFeedbackRequest request) {
        return ResponseEntity.ok(feedbackService.updateFeedback(request));
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('USER', 'SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        return ResponseEntity.ok(feedbackService.deleteFeedback(id));
    }
}
