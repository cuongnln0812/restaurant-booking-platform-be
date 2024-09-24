package com.foodbookingplatform.models.payload.dto.user;

import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
