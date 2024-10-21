package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.User;
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
    @Query("SELECT u.id FROM User u WHERE u.role.name = :roleName")
    List<Long> findAllUserIdByRoleName(@Param("roleName") String roleName);
}
