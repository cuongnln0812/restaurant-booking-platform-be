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
@Table(name = "payment_history")
public class PaymentHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_amount", nullable = false)
    private float totalAmount;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "booking_Id", referencedColumnName = "Id", nullable = false)
    private LocationBooking locationBooking;

    @ManyToOne
    @JoinColumn(name = "method_Id", referencedColumnName = "Id", nullable = false)
    private PaymentMethod paymentMethod;
}
