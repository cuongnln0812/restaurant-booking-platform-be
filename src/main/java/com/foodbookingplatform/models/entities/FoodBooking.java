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
public class FoodBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_date", nullable = false, length = 65535)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private float amount;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "created_date",nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "modified_by", insertable = false)
    private String modifiedBy;

    @Column(name = "modified_date", insertable = false)
    private LocalDateTime modifiedDate;

    @PrePersist
    protected void onCreate() {
        ZonedDateTime nowInVietnam = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.createdDate = nowInVietnam.toLocalDateTime();
        this.modifiedDate = nowInVietnam.toLocalDateTime();
    }

    @PreUpdate
    protected void onUpdate() {
        ZonedDateTime nowInVietnam = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.modifiedDate = nowInVietnam.toLocalDateTime();
    }

    @ManyToOne
    @JoinColumn(name = "booking_Id", referencedColumnName = "Id", nullable = false)
    private LocationBooking locationBooking;

    @ManyToOne
    @JoinColumn(name = "food_Id", nullable = false)
    private Food food;
}
