package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.payload.dto.uservoucher.UserVoucherResponse;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherRequest;
import com.foodbookingplatform.models.payload.dto.voucher.VoucherResponse;
import com.foodbookingplatform.services.VoucherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("api/v1/vouchers")
@RequiredArgsConstructor
public class VoucherController {
    private final VoucherService voucherService;

    @GetMapping
    public ResponseEntity<Page<VoucherResponse>> getAllVoucher(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDateTime endDate,
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

    @GetMapping("{id}")
    public ResponseEntity<VoucherResponse> getVoucherDetail(@PathVariable Long id) {
        return ResponseEntity.ok(voucherService.getVoucherDetail(id));
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserVoucherResponse>> viewUserVoucher() {
        List<UserVoucherResponse>  response = voucherService.viewAllVoucherOfUser();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<VoucherResponse> createVoucher(@RequestBody @Valid VoucherRequest request) {
        VoucherResponse response = voucherService.createVoucher(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/user/{voucherId}")
    public ResponseEntity<UserVoucherResponse> addVoucherForUser(@PathVariable Long voucherId) {
        UserVoucherResponse  response = voucherService.addVoucherForUser(voucherId);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<VoucherResponse> updateVoucher(@RequestBody @Valid VoucherRequest request) {
        return ResponseEntity.ok(voucherService.updateVoucher(request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<VoucherResponse> deleteVoucher(@PathVariable Long id) {
        return ResponseEntity.ok(voucherService.deleteVoucher(id));
    }
}
