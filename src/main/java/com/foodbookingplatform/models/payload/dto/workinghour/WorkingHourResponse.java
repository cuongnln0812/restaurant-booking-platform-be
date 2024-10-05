package com.foodbookingplatform.models.payload.dto.workinghour;

import com.foodbookingplatform.models.enums.DayInWeek;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHourResponse {
    private Long id;

    private DayInWeek day;

    private LocalTime startTime;

    private LocalTime endTime;
}
