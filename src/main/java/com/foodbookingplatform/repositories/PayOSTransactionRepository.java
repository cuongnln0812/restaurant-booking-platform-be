package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.PayOSTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayOSTransactionRepository extends JpaRepository<PayOSTransaction, Long> {
}
