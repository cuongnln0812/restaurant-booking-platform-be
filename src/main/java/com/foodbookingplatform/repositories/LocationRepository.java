package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Location;
import com.foodbookingplatform.models.enums.EntityStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long>, JpaSpecificationExecutor<Location> {
    List<Location> getLocationsByUserId(Long userId);

    int countLocationsByStatusEquals(EntityStatus status);

    @Query("SELECT l.id as locationId, l.name as locationName, l.phone as locationPhoneNumber, COUNT(lb.id) as bookingCount, " +
            "SUM(lb.amount) as totalBookingAmount " +
            "FROM Location l LEFT JOIN LocationBooking lb ON l.id = lb.location.id " +
            "WHERE MONTH(lb.bookingDate) = :month AND YEAR(lb.bookingDate) = :year AND lb.status = 'SUCCESSFUL' " +
            "GROUP BY l.id, l.name, l.phone")
    Page<Object[]> getLocationInfoAndNumberOfBookingInMonth(int month, int year, Pageable pageable);

}
