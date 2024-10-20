package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.PaymentHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
    PaymentHistory findPaymentHistoryByLocationBookingId(Long locationBookingId);
    @Query("SELECT ph FROM PaymentHistory ph " +
            "JOIN ph.locationBooking lb " +
            "JOIN lb.location l " +
            "WHERE l.id = :locationId")
    Page<PaymentHistory> findAllByLocationId(@Param("locationId") Long locationId, Pageable pageable);
}
