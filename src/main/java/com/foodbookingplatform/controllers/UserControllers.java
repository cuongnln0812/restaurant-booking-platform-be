package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.payload.dto.user.UserRequest;
import com.foodbookingplatform.models.payload.dto.user.UserResponse;
import com.foodbookingplatform.services.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllers {
    private final UserService userService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(userService.getAll(pageNo, pageSize, sortBy, sortDir));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserDetail(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getInfoById(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PutMapping
    public ResponseEntity<UserResponse> updateInfo(@RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(userService.updateInfo(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
