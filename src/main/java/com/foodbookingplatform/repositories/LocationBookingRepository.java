package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.LocationBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationBookingRepository extends JpaRepository<Long, LocationBooking>, JpaSpecificationExecutor<LocationBooking> {
}
