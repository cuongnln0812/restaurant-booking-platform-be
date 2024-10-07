package com.foodbookingplatform.utils;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.repositories.UserRepository;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.nio.file.AccessDeniedException;

@UtilityClass
public class SecurityUtils {

    public static boolean isAuthorizeLocation(Long id, UserRepository userRepository) throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userRepository.findByUserNameOrEmailOrPhone(userName, userName, userName)
                .orElseThrow(() -> new ResourceNotFoundException("User"));

        return user.getLocations().stream().anyMatch(location -> location.getId().equals(id));
    }
}
