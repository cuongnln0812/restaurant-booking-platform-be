package com.foodbookingplatform.models.payload.dto.feedback;

import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationFeedbackRequest {
    private Long id;

    @NotBlank(message = "Content must not be blank!")
    @Size(min = 20, message = "Content should be greater than 20 characters")
    private String content;

    @NotNull(message = "Rating must not be null!")
    @Range(min = 1, max = 5, message = "Rating should be between 1 to 5 star")
    private int rating;

    @NotBlank(message = "Image must not be blank!")
    private String image;

    @NotNull(message = "Location Booking Id must not be blank!")
    private Long locationBookingId;
}
