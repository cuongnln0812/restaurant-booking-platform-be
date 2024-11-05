package com.foodbookingplatform.models.payload.dto.feedback;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LocationFeedbackResponse {
    private Long id;

    private String content;

    private int rating;

    private LocalDate feedbackDate;

    private int numberOfGuest;

    private String image;

    private String locationName;

    private Long locationBookingId;

    private String userName;
}
