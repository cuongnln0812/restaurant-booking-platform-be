package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.OfferStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "voucher")
public class Voucher extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = Length.LONG)
    private String description;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, name = "quantity_use")
    private int quantityUse;

    @Column(nullable = false)
    private float discount;

    @Column(nullable = false, name = "max_discount_amount")
    private int maxDiscountAmount;

    @Column(nullable = false, name = "start_date")
    private LocalDateTime startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDateTime endDate;

    @Column(nullable = false, name = "min_order_amount")
    private float minOrderAmount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferStatus status;

    @OneToMany(mappedBy = "voucher")
    private Set<UserVoucher> userVouchers;

    @OneToMany(mappedBy = "voucher")
    private Set<LocationBooking> locationBookings;
}

