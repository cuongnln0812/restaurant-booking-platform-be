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
@Table(name = "promotion")
public class Promotion extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 65535)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OfferStatus status = OfferStatus.INACTIVE;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    // Shared fields for all types
    @Column(name = "discount_value")
    private Double discountValue;

    @Column(name = "max_discount")
    private Double maxDiscount;

    @Column(name = "free_item")
    private String freeItem;

    // Fields specific to BILL promotion
    @Column(name = "min_bill")
    private Double minBill;

    // Fields specific to PEOPLE promotion
    @Column(name = "min_people")
    private Integer minPeople;

    // Fields specific to TIME promotion
    @Column(name = "start_hour_time")
    private LocalDateTime startHourTime;

    @Column(name = "end_hour_time")
    private LocalDateTime endHourTime;

    @ManyToOne
    @JoinColumn(name = "location_Id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "promotion")
    private Set<LocationBooking> locationBookings;
}

