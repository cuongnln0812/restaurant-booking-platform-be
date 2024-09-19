package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.notification.NotificationRequest;
import com.foodbookingplatform.models.payload.dto.notification.NotificationResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface NotificationService{
    List<NotificationResponse> addNotification(NotificationRequest notificationRequest);
    NotificationResponse getNotification(Long id);
    Page<NotificationResponse> getAllNotifications(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<NotificationResponse> getAllNotificationsOfUser(int pageNo, int pageSize, String sortBy, String sortDir, Long id);
    Page<NotificationResponse> searchNotifications(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams);
    NotificationResponse updateNotification(NotificationRequest notificationRequest);
    void deleteNotification(long id);
}
