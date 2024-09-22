package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationTagRepository extends JpaRepository<LocationTag, Long> {
    @Query("SELECT lc.tag FROM LocationTag lc WHERE lc.location.id = :id")
    List<Tag> findTagsByLocationId(@Param("id") Long id);
    List<LocationTag> findByLocation(Location location);

}
