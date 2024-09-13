package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.auth.JWTAuthResponse;
import com.foodbookingplatform.models.payload.dto.auth.LoginDto;
import com.foodbookingplatform.models.payload.dto.auth.SignupDto;
import com.foodbookingplatform.models.payload.dto.auth.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    JWTAuthResponse authenticateUser(LoginDto loginDto);
    JWTAuthResponse signupUser(SignupDto signupDto);
    JWTAuthResponse signupLocation(SignupDto signupDto);
    UserDto getCustomerInfo();
    ResponseEntity<JWTAuthResponse> refreshToken(HttpServletRequest request, HttpServletResponse response);
    void changePassword(String oldPassword, String newPassword);
}
