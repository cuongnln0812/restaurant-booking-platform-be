package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryRequest;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryResponse;
import com.foodbookingplatform.services.PaymentHistoryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment-histories")
@RequiredArgsConstructor
public class PaymentHistoryController {
    private final PaymentHistoryService paymentHistoryService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('USER', 'LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<PaymentHistoryResponse>> getPaymentHistoriesPagination(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(paymentHistoryService.getAll(pageNo, pageSize, sortBy, sortDir));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('USER', 'LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @GetMapping("locations/{locationId}")
    public ResponseEntity<Page<PaymentHistoryResponse>> getPaymentHistoriesOfLocationPagination(
            @PathVariable(name = "locationId") Long locationId,
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(paymentHistoryService.getAllByLocationId(locationId, pageNo, pageSize, sortBy, sortDir));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('USER', 'LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<PaymentHistoryResponse> getPaymentHistoryById(@PathVariable Long id) {
        PaymentHistoryResponse reportResponse = paymentHistoryService.get(id);
        return ResponseEntity.ok(reportResponse);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('USER', 'LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @PostMapping
    public ResponseEntity<PaymentHistoryResponse> add(@RequestBody @Valid PaymentHistoryRequest request) {
        return ResponseEntity.ok(paymentHistoryService.add(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @PutMapping
    public ResponseEntity<PaymentHistoryResponse> update(@RequestBody @Valid PaymentHistoryRequest request) {
        return ResponseEntity.ok(paymentHistoryService.update(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paymentHistoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
