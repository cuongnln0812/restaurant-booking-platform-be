package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {

}
