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
public class UserVoucher extends BaseEntity{

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

    @Override
    protected void onCreate() {
        super.onCreate();
        ZonedDateTime nowInVietnam = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.assignedDate = nowInVietnam.toLocalDateTime();
        this.usedDate = nowInVietnam.toLocalDateTime();
    }

    @Override
    protected void onUpdate() {
        super.onUpdate();
        ZonedDateTime nowInVietnam = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.usedDate = nowInVietnam.toLocalDateTime();
    }

    @ManyToOne
    @JoinColumn(name = "voucher_Id", nullable = false)
    private Voucher voucher;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;
}

