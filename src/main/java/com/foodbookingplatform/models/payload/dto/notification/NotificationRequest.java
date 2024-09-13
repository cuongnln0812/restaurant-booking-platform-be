package com.foodbookingplatform.models.payload.dto.notification;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private Long id;

    @NotEmpty(message = "Notification's recipient type cannot be blank")
    @Pattern(regexp = AppConstants.RECIPIENT_TYPE_REGEX, message = "Gender include: USER, LOCATION")
    @Size(min = 2, message = "RecipientType's recipient type must have at least 2 characters")
    private String recipientType;

    @NotEmpty(message = "Notification's notification type cannot be blank")
    @Pattern(regexp = AppConstants.NOTIFICATION_TYPE_REGEX, message = "Gender include: ORDER, PROMOTION, OTHER")
    @Size(min = 2, message = "NotificationType's notification type must have at least 2 characters")
    private String notificationType;

    @NotEmpty(message = "Notification's title cannot be blank")
    @Size(min = 2, message = "Notification's title must have at least 2 characters")
    private String title;

    @NotEmpty(message = "Notification's title cannot be blank")
    @Size(min = 2, message = "Notification's title must have at least 2 characters")
    private String summary;

    @NotEmpty(message = "Notification's title cannot be blank")
    @Size(min = 2, message = "Notification's title must have at least 2 characters")
    private String content;

    @NotEmpty(message = "Notification's title cannot be blank")
    @Size(min = 2, message = "Notification's title must have at least 2 characters")
    private String image;

    private EntityStatus status;

    @NotNull(message = "User_id cannot be null")
    private Long user_id;
}
