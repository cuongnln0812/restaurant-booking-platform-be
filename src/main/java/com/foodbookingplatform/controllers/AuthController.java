package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.payload.dto.auth.JWTAuthResponse;
import com.foodbookingplatform.models.payload.dto.auth.LoginDto;
import com.foodbookingplatform.models.payload.dto.auth.PasswordChangeRequest;
import com.foodbookingplatform.models.payload.dto.auth.SignupDto;
import com.foodbookingplatform.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(
            summary = "Login User",
            description = "Login user by UserName, Email, Phone"
    )
    @PostMapping("/login")
    public ResponseEntity<Object> authenticationUser(@Valid @RequestBody LoginDto loginDto){
        JWTAuthResponse jwtAuthResponse = authService.authenticateUser(loginDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtAuthResponse.getAccessToken());
        return new ResponseEntity<>(jwtAuthResponse, headers, HttpStatus.OK);
    }

    @Operation(
            summary = "Sign Up Account User"
    )
    @PostMapping(value = "/register/user")
    public ResponseEntity<Object> signupUser(@Valid @RequestBody SignupDto signupDto){
        JWTAuthResponse response = authService.signupUser(signupDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Sign Up Account Location's Admin"
    )
    @PostMapping(value = "/register/location")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    public ResponseEntity<Object> signupLocation(@Valid @RequestBody SignupDto signupDto){
        JWTAuthResponse response = authService.signupLocation(signupDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/change-password")
    public ResponseEntity<Object> changePassword(@RequestBody PasswordChangeRequest request) {
        authService.changePassword(request.getOldPassword(), request.getNewPassword());
        return new ResponseEntity<>("Password changed successfully", HttpStatus.OK);
    }

    @Operation(
            summary = "Generate AccessToken and Refresh Token"
    )
    @PostMapping("/refresh_token")
    public ResponseEntity<JWTAuthResponse> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return authService.refreshToken(request, response);
    }

    @Operation(
            summary = "Get Info User"
    )
    @SecurityRequirement(name = "Bear Authentication")
    @GetMapping("/info")
    public ResponseEntity<Object> getInfo() {
        return ResponseEntity.ok(authService.getCustomerInfo());
    }
}
