package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.OfferStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ads_registration")
public class AdsRegistration extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date", nullable = false, length = 65535)
    private LocalDateTime registrationDate;

    @Column(name = "expire_date", nullable = false, length = 65535)
    private LocalDateTime expireDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OfferStatus status = OfferStatus.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "location_Id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "ads_Id", nullable = false)
    private Ads ads;
}
