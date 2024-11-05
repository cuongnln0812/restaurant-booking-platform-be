package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.enums.EntityStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserNameOrEmailOrPhone(String email, String userName, String phone);
    List<User> findByRoleNameContainsIgnoreCase(String name);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);
    Optional<User> findByUserName(String username);
    List<User> findAllByRoleName(String roleName);
    int countUsersByStatusEqualsAndRoleNameEquals(EntityStatus status, String roleName);
}
