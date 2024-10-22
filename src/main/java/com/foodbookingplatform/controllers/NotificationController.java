package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.payload.dto.notification.NotificationRequest;
import com.foodbookingplatform.models.payload.dto.notification.NotificationResponse;
import com.foodbookingplatform.services.NotificationService;
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

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('USER') or hasRole('LOCATION_ADMIN') or hasRole('SYSTEM_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<NotificationResponse>> getAllNotifications(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(notificationService.getAllNotifications(pageNo, pageSize, sortBy, sortDir));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('USER') or hasRole('LOCATION_ADMIN') or hasRole('SYSTEM_ADMIN')")
    @GetMapping("/user/{id}")
    public ResponseEntity<Page<NotificationResponse>> getAllNotificationsOfUser(
            @PathVariable Long id,
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(notificationService.getAllNotificationsOfUser(pageNo, pageSize, sortBy, sortDir, id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('USER') or hasRole('LOCATION_ADMIN') or hasRole('SYSTEM_ADMIN')")
    @GetMapping("/search")
    public ResponseEntity<Page<NotificationResponse>> searchNotifications(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "sendDateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime sendDateFrom,
            @RequestParam(value = "sendDateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime sendDateTo,
            @RequestParam(value = "status", required = false) List<EntityStatus> status,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "summary", required = false) String summary,
            @RequestParam(value = "content", required = false) Long content,
            @RequestParam(value = "recipientType", required = false) String recipientType,
            @RequestParam(value = "notificationType", required = false) String notificationType,
            @RequestParam(value = "fullName", required = false) String fullName) {

        Map<String, Object> searchParams = new HashMap<>();

        if (status != null && !status.isEmpty()) searchParams.put("status", status);
        if (sendDateFrom != null) searchParams.put("sendDateFrom", sendDateFrom);
        if (sendDateTo != null) searchParams.put("sendDateTo", sendDateTo);
        if (summary != null) searchParams.put("summary", summary);
        if (content != null) searchParams.put("content", content);
        if (title != null) searchParams.put("title", title);
        if (recipientType != null) searchParams.put("recipientType", recipientType);
        if (notificationType != null) searchParams.put("notificationType", notificationType);
        if (fullName != null) searchParams.put("fullName", fullName);

        return ResponseEntity.ok(notificationService.searchNotifications(pageNo, pageSize, sortBy, sortDir, searchParams));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PostMapping("/commission-monthly-payment/{userId}")
    public ResponseEntity<Map<String, Object>> receiveNotification(
            @PathVariable(name = "userId") Long userId,
            @RequestBody(required = false) Map<String, Object> payload) {
        int month = ((Number) payload.get("month")).intValue();
        int year = ((Number) payload.get("year")).intValue();
        int totalAmount = ((Number) payload.get("totalAmount")).intValue();
        DecimalFormat currencyFormat = new DecimalFormat("#,###");
        String formattedTotalAmount = currencyFormat.format(totalAmount);

        // Tạo một map để chứa thông tin phản hồi
        Map<String, Object> responsePayload = new HashMap<>();
        responsePayload.put("status", "success");
        responsePayload.put("message", "Thanh toán tiền hoa hồng tháng " + month + "/" + year + " số tiền: " + formattedTotalAmount + " VND");
        responsePayload.put("totalAmount", totalAmount);

        // Trả về response với thông điệp và totalAmount
        return ResponseEntity.ok(responsePayload);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('USER') or hasRole('LOCATION_ADMIN') or hasRole('SYSTEM_ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<NotificationResponse> getNotification(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.getNotification(id));
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 Created")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('LOCATION_ADMIN') or hasRole('SYSTEM_ADMIN')")
    @PostMapping
    public ResponseEntity<List<NotificationResponse>> addNotification(@Valid @RequestBody NotificationRequest request) {
        List<NotificationResponse> response = notificationService.addNotification(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('LOCATION_ADMIN') or hasRole('SYSTEM_ADMIN')")
    @PutMapping
    public ResponseEntity<NotificationResponse> updateNotification(@Valid @RequestBody NotificationRequest request) {
        return ResponseEntity.ok(notificationService.updateNotification(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('LOCATION_ADMIN') or hasRole('SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok("Notification deleted successfully");
    }
}
