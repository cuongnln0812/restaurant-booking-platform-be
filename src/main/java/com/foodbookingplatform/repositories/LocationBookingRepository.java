package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Location;
import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.enums.LocationBookingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationBookingRepository extends JpaRepository<LocationBooking, Long>, JpaSpecificationExecutor<LocationBooking> {
    Page<LocationBooking> findAllByLocationId(Long locationId, Specification<LocationBooking> spec, Pageable pageable);
    Page<LocationBooking> findAllByUser(User user, Specification<LocationBooking> spec, Pageable pageable);
    Page<LocationBooking> findAllByLocationId(Long locationId, Pageable pageable);
    Page<LocationBooking> findAllByUser(User user, Pageable pageable);
    @Query("SELECT b FROM LocationBooking b WHERE b.user.id = :userId " +
            "AND b.status = :status " +
            "AND FUNCTION('MONTH', b.bookingDate) = :month " +
            "AND FUNCTION('YEAR', b.bookingDate) = :year")
    List<LocationBooking> findAllSuccessfulBookings(@Param("userId") Long userId,
                                                    @Param("status") LocationBookingStatus status,
                                                    @Param("month") int month,
                                                    @Param("year") int year);
    List<LocationBooking> findAllByLocationUserAndStatus(User user, LocationBookingStatus status);
}
