package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.WorkingHour;
import com.foodbookingplatform.models.enums.DayInWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkingHourRepository extends JpaRepository<WorkingHour, Long> {
    List<WorkingHour> findByLocation_Id(Long id);

    WorkingHour findByLocation_IdAndDay(Long id, DayInWeek day);
}
