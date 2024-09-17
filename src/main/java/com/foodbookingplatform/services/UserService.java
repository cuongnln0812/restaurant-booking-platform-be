package com.foodbookingplatform.services;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.payload.dto.user.UserRequest;
import com.foodbookingplatform.models.payload.dto.user.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAll(int pageNo, int pageSize, String sortBy, String sortDir);
    List<UserResponse> search(int pageNo, int pageSize, String sortBy, String sortDir, String keyword);
    UserResponse getInfoById(Long id);
    UserResponse updateInfo(UserRequest request);
    UserResponse deleteUser(Long id);
}
