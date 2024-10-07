package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.AdsType;
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
@Table(name = "ads")
public class Ads extends BaseEntity{
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
    private AdsType type;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityStatus status = EntityStatus.ACTIVE;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @Column(nullable = false)
    private int duration;

    @OneToMany(mappedBy = "ads")
    private Set<AdsRegistration> adsRegistrations;

    @OneToMany(mappedBy = "ads")
    private Set<PackageAds> packageAds;
}
