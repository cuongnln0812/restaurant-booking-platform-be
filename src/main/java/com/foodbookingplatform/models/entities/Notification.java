package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.EntityStatus;
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
@Table(name = "address")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipient_type", nullable = false)
    private String recipientType;

    @Column(name = "notification_type", nullable = false)
    private String notificationType;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityStatus status;

    @Column(name = "send_date", nullable = false)
    private LocalDateTime sendDate;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "created_date",nullable = false, updatable = false)
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
    @JoinColumn(name = "recipient_Id", referencedColumnName = "Id", nullable = false)
    private User user;
}
