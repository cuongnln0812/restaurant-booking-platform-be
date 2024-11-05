package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "location")
public class Location extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private int onSuggest = 0;

    @Column(nullable = false)
    private int onSale = 0;

    @Column(nullable = false)
    private int onBanner = 0;

    @Column(nullable = false)
    private int view = 0;

    @Column(nullable = false)
    private int rating = 0;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(name = "geo_hash_code", nullable = false)
    private String geoHashCode;

    @Column(nullable = false, length = 65535)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityStatus status = EntityStatus.ACTIVE;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @Column(name = "banner_image")
    private String bannerImage;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "brand_Id", nullable = false)
    private Brand brand;

    @OneToMany(mappedBy = "location")
    private Set<PackageRegistration> packageRegistrations;

    @OneToMany(mappedBy = "location")
    private Set<AdsRegistration> adsRegistrations;

    @OneToMany(mappedBy = "location")
    private Set<Promotion> promotions;

    @OneToMany(mappedBy = "location")
    private Set<LocationBooking> locationBookings;

    @OneToMany(mappedBy = "location")
    private Set<LocationTag> locationTags;

    @OneToMany(mappedBy = "location")
    private Set<Food> foods;

    @OneToMany(mappedBy = "location")
    private Set<LocationCategory> locationCategories;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Set<WorkingHour> workingHours;
}


