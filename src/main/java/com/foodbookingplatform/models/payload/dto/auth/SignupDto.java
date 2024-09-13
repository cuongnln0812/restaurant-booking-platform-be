package com.foodbookingplatform.models.payload.dto.auth;

import com.foodbookingplatform.models.constants.AppConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {

    @NotBlank(message = "Username, email cannot be blank")
    @Size(min = 8, message = "Username, email must have at least 8 characters")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email is not valid")
    @Pattern(regexp = AppConstants.EMAIL_REGEX, message = "Email is invalid!")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = AppConstants.PASSWORD_REGEX, message = "Password must be at least 8 characters with at least one uppercase letter, one number, and one special character (!@#$%^&*).")
    private String password;

    @NotBlank(message = "FullName cannot be blank")
    private String fullName;

    @NotBlank(message = "Phone cannot be blank")
    @Pattern(regexp = AppConstants.PHONE_REGEX, message = "Invalid phone number!")
    private String phone;

    @NotBlank(message = "Gender cannot be blank")
    @Pattern(regexp = AppConstants.GENDER_REGEX, message = "Gender include: Male, Female, Other")
    private String gender;
}
