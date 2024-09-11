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
@Table(name = "user_voucher")
public class UserVoucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false, name = "quantity_available")
    private int quantityAvailable;

    @Column(nullable = false, name = "assigned_date")
    private LocalDateTime assignedDate;

    @Column(nullable = false, name = "used_date")
    private LocalDateTime usedDate;

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
        this.assignedDate = nowInVietnam.toLocalDateTime();
        this.usedDate = nowInVietnam.toLocalDateTime();
    }

    @PreUpdate
    protected void onUpdate() {
        ZonedDateTime nowInVietnam = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.modifiedDate = nowInVietnam.toLocalDateTime();
        this.usedDate = nowInVietnam.toLocalDateTime();
    }

    @ManyToOne
    @JoinColumn(name = "voucher_Id", nullable = false)
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;
}

