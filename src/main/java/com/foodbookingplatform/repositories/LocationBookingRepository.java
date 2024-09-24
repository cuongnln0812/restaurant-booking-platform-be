package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.LocationBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationBookingRepository extends JpaRepository<LocationBooking, Long> {

}
