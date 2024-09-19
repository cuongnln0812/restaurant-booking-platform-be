package com.foodbookingplatform.models.payload.dto.notification;

import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private Long id;

    private String recipientType;

    private String notificationType;

    private String title;

    private String summary;

    private String content;

    private String image;

    private EntityStatus status;

    private LocalDateTime sendDate;

    private String fullName;

    private String createdBy;

    private String modifiedBy;
}
