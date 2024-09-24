package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
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
@Table(name = "notification")
public class Notification extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipient_type", nullable = false)
    private String recipientType;

    @Column(name = "notification_type", nullable = false)
    private String notificationType;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String summary;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String content;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EntityStatus status = EntityStatus.ACTIVE;

    @Column(name = "send_date", nullable = false)
    private LocalDateTime sendDate;

    @Override
    protected void onCreate() {
        super.onCreate();
        ZonedDateTime nowInVietnam = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        this.sendDate = nowInVietnam.toLocalDateTime();
    }

    @ManyToOne
    @JoinColumn(name = "recipient_Id", referencedColumnName = "id", nullable = false)
    private User user;
}
