package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmailOrPhone(String email, String userName, String phone);
    List<User> findByRoleName(String name);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
    Optional<User> findByUserName(String username);
}
