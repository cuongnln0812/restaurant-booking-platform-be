package com.foodbookingplatform.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "location_feedback")
public class LocationFeedback extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 65535)
    private String content;

    @Column(nullable = false)
    private int rating;

    @Column(name = "feedback_date", nullable = false)
    private LocalDate feedbackDate;

    @Column(name = "number_of_guest", nullable = false, length = 65535)
    private int numberOfGuest;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @ManyToOne
    @JoinColumn(name = "booking_Id", referencedColumnName = "Id", nullable = false)
    private LocationBooking locationBooking;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;
}


