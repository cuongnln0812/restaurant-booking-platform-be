package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationBookingRepository extends JpaRepository<LocationBooking, Long>, JpaSpecificationExecutor<LocationBooking> {
    Page<LocationBooking> findAllByLocationId(Long locationId, Specification<LocationBooking> spec, Pageable pageable);
    Page<LocationBooking> findAllByUser(User user, Specification<LocationBooking> spec, Pageable pageable);
    Page<LocationBooking> findAllByLocationId(Long locationId, Pageable pageable);
    Page<LocationBooking> findAllByUser(User user, Pageable pageable);
}
