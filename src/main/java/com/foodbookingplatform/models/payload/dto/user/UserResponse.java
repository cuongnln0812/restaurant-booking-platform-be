package com.foodbookingplatform.models.payload.dto.user;

import com.foodbookingplatform.models.enums.EntityStatus;

public class UserResponse {
    private Long id;
    private String userName;
    private String fullName;
    private String email;
    private String phone;
    private String gender;
    private EntityStatus status;
    private int point;
    private boolean isFirstLogin;
    private String image;
    private String roleName;
}
