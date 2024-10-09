package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Voucher;
import com.foodbookingplatform.models.enums.OfferStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Long>, JpaSpecificationExecutor<Voucher> {
    boolean existsByCode(String code);
    List<Voucher> findVoucherByStartDateAndStatus(LocalDateTime startDate, OfferStatus status);
    List<Voucher> findVoucherByEndDateAndStatus(LocalDateTime endDate, OfferStatus status);
}
