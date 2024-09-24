package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    boolean existsByCode(String code);
}
