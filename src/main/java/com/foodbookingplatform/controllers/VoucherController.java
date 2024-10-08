package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.payload.dto.uservoucher.ApplyUserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherRequest;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherResponse;
import com.foodbookingplatform.services.VoucherService;
import io.swagger.v3.oas.annotations.Operation;
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

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/vouchers")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bear Authentication")
public class VoucherController {
    private final VoucherService voucherService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping
    public ResponseEntity<Page<VoucherResponse>> getAllVoucher(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "status", required = false) List<OfferStatus> status,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "condition", required = false) String code,
            @RequestParam(value = "title", required = false) Long name
    ) {
        Map<String, Object> searchParams = new HashMap<>();

        if (status != null && !status.isEmpty()) searchParams.put("status", status);
        if (startDate != null) searchParams.put("startDate", startDate);
        if (endDate != null) searchParams.put("endDate", endDate);
        if (description != null) searchParams.put("description", description);
        if (name != null) searchParams.put("name", name);
        if (code != null) searchParams.put("code", code);

        return ResponseEntity.ok(voucherService.viewAllVoucher(pageNo, pageSize, sortBy, sortDir,  searchParams));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping("{id}")
    public ResponseEntity<VoucherResponse> getVoucherDetail(@PathVariable Long id) {
        return ResponseEntity.ok(voucherService.getVoucherDetail(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasAnyRole('USER', 'SYSTEM_ADMIN')")
    @GetMapping("/user")
    public ResponseEntity<List<UserVoucherResponse>> viewUserVoucher() {
        List<UserVoucherResponse>  response = voucherService.viewAllVoucherOfUser();
        return ResponseEntity.ok(response);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @Operation(description = "Use for getting usable voucher list of logged in user and the total price of the booking " +
            "If it is usable, it returns response contains voucher's detail and isUsable true, or else false")
    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/user/usable-vouchers")
    public ResponseEntity<List<ApplyUserVoucherResponse>> viewUsableVoucherOfUser(@RequestParam Float totalPrice) {
        List<ApplyUserVoucherResponse> response = voucherService.getUsableVoucherListOfUser(totalPrice);
        return ResponseEntity.ok(response);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @Operation(description = "Use for checking and applying voucher. " +
            "If it is usable, it returns the discounted value from the total price, or else throws exception with error message")
    @PreAuthorize("hasAnyRole('USER')")
    @PostMapping("/applying/{voucherId}")
    public ResponseEntity<Float> applyVoucher(@PathVariable Long voucherId, @RequestParam Float totalPrice) {
        Float response = voucherService.applyVoucher(voucherId, totalPrice);
        return ResponseEntity.ok(response);
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATE")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PostMapping
    public ResponseEntity<VoucherResponse> createVoucher(@RequestBody @Valid VoucherRequest request) {
        VoucherResponse response = voucherService.createVoucher(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATE")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/{voucherId}")
    public ResponseEntity<UserVoucherResponse> addVoucherForUser(@PathVariable Long voucherId) {
        UserVoucherResponse  response = voucherService.addVoucherForUser(voucherId);
        return ResponseEntity.ok(response);
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATE")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PutMapping
    public ResponseEntity<VoucherResponse> updateVoucher(@RequestBody @Valid VoucherRequest request) {
        return ResponseEntity.ok(voucherService.updateVoucher(request));
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATE")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<VoucherResponse> deleteVoucher(@PathVariable Long id) {
        return ResponseEntity.ok(voucherService.deleteVoucher(id));
    }
}
