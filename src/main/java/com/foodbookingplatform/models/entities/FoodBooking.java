package com.foodbookingplatform.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "food_booking")
public class FoodBooking extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_date", nullable = false, length = 65535)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private float amount;

    @ManyToOne
    @JoinColumn(name = "booking_Id", referencedColumnName = "Id", nullable = false)
    private LocationBooking locationBooking;

    @ManyToOne
    @JoinColumn(name = "food_Id", nullable = false)
    private Food food;
}
