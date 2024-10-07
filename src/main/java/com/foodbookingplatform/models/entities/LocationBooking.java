package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.LocationBookingStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "location_booking")
public class LocationBooking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "booking_time", nullable = false)
    private LocalTime bookingTime;

    @Column(name = "number_of_guest", nullable = false, length = 65535)
    private int numberOfGuest;

    @Column(name = "number_of_adult", nullable = false, length = 65535)
    private int numberOfAdult;

    @Column(name = "number_of_children", nullable = false, length = 65535)
    private int numberOfChildren;

    @Column
    private float amount;

    @Column
    private float commission;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LocationBookingStatus status;

    @ManyToOne
    @JoinColumn(name = "location_Id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "voucher_Id")
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "promotion_Id")
    private Promotion promotion;

    @OneToMany(mappedBy = "locationBooking")
    private Set<LocationFeedback> locationFeedbacks;

    @OneToMany(mappedBy = "locationBooking")
    private Set<PaymentHistory> paymentHistories;

    @OneToMany(mappedBy = "locationBooking")
    private Set<FoodBooking> foodBookings;
}


