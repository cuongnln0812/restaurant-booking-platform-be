package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.payload.dto.promotion.ApplyPromotionResponse;
import com.foodbookingplatform.models.payload.dto.promotion.CheckPromotionResponse;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionRequest;
import com.foodbookingplatform.models.payload.dto.promotion.PromotionResponse;
import com.foodbookingplatform.services.PromotionService;
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
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/promotions")
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;
    private final Map<String, Object> searchParams = new HashMap<>();

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<PromotionResponse>> getAllPromotions(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(promotionService.getAllPromotions(pageNo, pageSize, sortBy, sortDir));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('SYSTEM_ADMIN', 'LOCATION_ADMIN')")
    @GetMapping("/location/{id}")
    public ResponseEntity<Page<PromotionResponse>> getAllPromotionsOfLocation(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @PathVariable Long id
    ) throws AccessDeniedException {
        return ResponseEntity.ok(promotionService.getAllPromotionsOfLocation(pageNo, pageSize, sortBy, sortDir, id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping("/search")
    public ResponseEntity<Page<PromotionResponse>> searchPromotions(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endDate,
            @RequestParam(value = "status", required = false) List<OfferStatus> status,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "title", required = false) String title
    ){

        if (status != null && !status.isEmpty()) searchParams.put("status", status);
        if (startDate != null) searchParams.put("startDate", startDate);
        if (endDate != null) searchParams.put("endDate", endDate);
        if (description != null) searchParams.put("description", description);
        if (title != null) searchParams.put("title", title);

        return ResponseEntity.ok(promotionService.searchAllPromotions(pageNo, pageSize, sortBy, sortDir, searchParams));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping("{id}")
    public ResponseEntity<PromotionResponse> getPromotion(@PathVariable Long id) {
        return ResponseEntity.ok(promotionService.getPromotion(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping("/usable-promotions/{locationId}")
    public ResponseEntity<List<ApplyPromotionResponse>> getUsablePromotionListOfLocation(
            @PathVariable Long locationId,
            @RequestParam(required = false) Float totalPrice,
            @RequestParam(required = false) Integer numberOfPeople,
            @RequestParam(required = false) LocalDate bookingDate,
            @RequestParam(required = false) LocalTime bookingTime) {
        return ResponseEntity.ok(promotionService.getUsablePromotionListOfLocation(locationId, totalPrice, numberOfPeople, bookingDate, bookingTime));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PostMapping("/applying/{locationId}")
    public ResponseEntity<CheckPromotionResponse> applyPromotion(
            @PathVariable Long locationId,
            @RequestParam(required = false) Float totalPrice,
            @RequestParam(required = false) Integer numberOfPeople,
            @RequestParam(required = false) LocalDate bookingDate,
            @RequestParam(required = false) LocalTime bookingTime) {
        return ResponseEntity.ok(promotionService.applyPromotion(locationId, totalPrice, numberOfPeople, bookingDate, bookingTime));
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 Created")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @PostMapping
    public ResponseEntity<PromotionResponse> addPromotion(@Valid @RequestBody PromotionRequest request) {
        PromotionResponse response = promotionService.addPromotion(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @PutMapping
    public ResponseEntity<PromotionResponse> updatePromotion(@Valid @RequestBody PromotionRequest request) throws AccessDeniedException {
        return ResponseEntity.ok(promotionService.updatePromotion(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePromotion(@PathVariable Long id) throws AccessDeniedException {
        promotionService.deletePromotion(id);
        return ResponseEntity.ok("Promotion deleted successfully");
    }
}
