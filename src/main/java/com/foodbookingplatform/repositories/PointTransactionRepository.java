package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.PointTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointTransactionRepository extends JpaRepository<PointTransaction, Long> {
}
