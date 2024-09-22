package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Category;
import com.foodbookingplatform.models.entities.Location;
import com.foodbookingplatform.models.entities.LocationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationCategoryRepository extends JpaRepository<LocationCategory, Long> {
    @Query("SELECT lc.category FROM LocationCategory lc WHERE lc.location.id = :id")
    List<Category> findCategoriesByLocationId(@Param("id") Long id);

    List<LocationCategory> findByLocation(Location location);
}
