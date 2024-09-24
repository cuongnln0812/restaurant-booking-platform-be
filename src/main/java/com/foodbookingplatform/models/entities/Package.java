package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.OfferStatus;
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
@Table(name = "package")
public class Package extends BaseEntity{

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
    private OfferStatus status;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @Column(name = "duration", nullable = false)
    private String duration;

    @OneToMany(mappedBy = "aPackage")
    private Set<PackageRegistration> packageRegistrations;
}
