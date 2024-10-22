package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.MonthlyCommissionPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthlyCommissionPaymentRepository extends JpaRepository<MonthlyCommissionPayment, Long> {
    Optional<MonthlyCommissionPayment> findByUserIdAndMonthAndYear(long userId, int month, int year);
    Optional<MonthlyCommissionPayment> findByUserId(Long userId);
}
