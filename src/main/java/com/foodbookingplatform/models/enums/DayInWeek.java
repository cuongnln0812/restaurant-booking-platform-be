package com.foodbookingplatform.models.enums;

import com.foodbookingplatform.models.exception.RestaurantBookingException;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@ToString
public enum DayInWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;


    public static void isValid(DayInWeek dayInWeek) {
        if (dayInWeek == null) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Day is not valid");
        }
        for (DayInWeek s : DayInWeek.values()) {
            if (s.toString().equals(dayInWeek.name())) {
                return;
            }
        }
        throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Day is not valid");
    }
}
