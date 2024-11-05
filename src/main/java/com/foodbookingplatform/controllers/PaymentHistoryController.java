package com.foodbookingplatform.controllers;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.entities.MonthlyCommissionPayment;
import com.foodbookingplatform.models.enums.PaymentStatus;
import com.foodbookingplatform.models.payload.dto.paymenthistory.LocationRevenueReportPaginationResponse;
import com.foodbookingplatform.models.payload.dto.paymenthistory.MonthlyRevenueResponse;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryRequest;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryResponse;
import com.foodbookingplatform.models.payload.dto.paymenthistory.RecentPaymentResponse;
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
    @PreAuthorize("hasAnyRole('LOCATION_ADMIN')")
    @GetMapping("/monthly-commission-payment")
    public ResponseEntity<MonthlyCommissionPayment> getMonthlyPaymentHistory(@RequestParam(name = "month") int month, @RequestParam(name = "year") int year) {
        MonthlyCommissionPayment reportResponse = paymentHistoryService.getMonthlyPaymentOfLocationAdminByMonthAndYear(month, year);
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

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping(path = "/payos-transfer-handler")
    public ResponseEntity<ObjectNode> payOsTransferHandler(@RequestBody ObjectNode body) throws JsonProcessingException {
        ObjectNode node = paymentHistoryService.payOsTransferHandler(body);
        return ResponseEntity.ok(node);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('SYSTEM_ADMIN')")
    @GetMapping("get-total-revenue-of-system")
    public ResponseEntity<Double> getTotalRevenueOfSystem(
            @RequestParam int month,
            @RequestParam int year
    ) {
        return ResponseEntity.ok(paymentHistoryService.getTotalRevenueOfSystem(month, year));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('SYSTEM_ADMIN')")
    @GetMapping("get-revenue-of-each-month")
    public ResponseEntity<List<MonthlyRevenueResponse>> getTotalRevenueOfSystemForYear(
            @RequestParam int year
    ) {
        return ResponseEntity.ok(paymentHistoryService.getTotalRevenueOfSystemForYear(year));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('SYSTEM_ADMIN')")
    @GetMapping("get-recent-payment-histories")
    public ResponseEntity<List<RecentPaymentResponse>> getRecentPaymentHistories(
            @RequestParam PaymentStatus status,
            @RequestParam int top
    ) {
        return ResponseEntity.ok(paymentHistoryService.getRecentPaymentHistories(status, top));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('SYSTEM_ADMIN')")
    @GetMapping("get-location-revenue-reports")
    public ResponseEntity<LocationRevenueReportPaginationResponse> getLocationRevenueReports(
            @RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam int month,
            @RequestParam int year
    ) {
        return ResponseEntity.ok(paymentHistoryService.getLocationRevenueReports(pageNo, pageSize, sortBy, sortDir, month, year));
    }
}
