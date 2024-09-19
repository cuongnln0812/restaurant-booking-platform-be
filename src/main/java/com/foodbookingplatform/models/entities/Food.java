package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "food")
public class Food extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false, length = 65535)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityStatus status;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @ManyToOne
    @JoinColumn(name = "food_category_id", referencedColumnName = "Id", nullable = false)
    private FoodCategory foodCategory;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "food")
    private Set<FoodBooking> foodBookings;
}
