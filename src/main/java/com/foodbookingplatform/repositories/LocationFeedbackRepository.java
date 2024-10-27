package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Location;
import com.foodbookingplatform.models.entities.LocationFeedback;
import com.foodbookingplatform.models.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface LocationFeedbackRepository extends JpaRepository<LocationFeedback, Long>, JpaSpecificationExecutor<LocationFeedback> {
    Page<LocationFeedback> findAllByLocationBookingLocation(Location location, Pageable pageable);
    Page<LocationFeedback> findAllByUser(User user, Pageable pageable);
}
