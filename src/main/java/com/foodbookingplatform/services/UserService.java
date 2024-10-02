package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.user.UserRequest;
import com.foodbookingplatform.models.payload.dto.user.UserResponse;
import org.springframework.data.domain.Page;



public interface UserService {
    Page<UserResponse> getAll(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<UserResponse> search(int pageNo, int pageSize, String sortBy, String sortDir, String keyword);
    UserResponse getInfoById(Long id);
    UserResponse updateInfo(UserRequest request);
    UserResponse deleteUser(Long id);
}
