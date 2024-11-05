package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "booking_Id", referencedColumnName = "Id", nullable = false)
    private LocationBooking locationBooking;

    @ManyToOne
    @JoinColumn(name = "method_Id", referencedColumnName = "Id", nullable = false)
    private PaymentMethod paymentMethod;
}
