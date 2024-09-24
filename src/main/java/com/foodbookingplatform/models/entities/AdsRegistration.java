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
@Table(name = "ads_registration")
public class AdsRegistration extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date", nullable = false, length = 65535)
    private LocalDateTime registrationDate;

    @Column(name = "expire_date", nullable = false, length = 65535)
    private LocalDateTime expireDate;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "location_Id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "ads_Id", nullable = false)
    private Ads ads;
}
