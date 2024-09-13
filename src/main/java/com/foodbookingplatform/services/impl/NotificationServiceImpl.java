package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Notification;
import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.notification.NotificationRequest;
import com.foodbookingplatform.models.payload.dto.notification.NotificationResponse;
import com.foodbookingplatform.repositories.NotificationRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public List<NotificationResponse> addNotification(NotificationRequest notificationRequest) {
        List<Notification> notificationList = new ArrayList<>();
        List<Notification> notificationSaved = new ArrayList<>();

        if(notificationRequest.getUser_id() == 0){
            List<User> users = userRepository.findByRoleName(notificationRequest.getRecipientType());
            for(User user : users){
                Notification notification = mapper.map(notificationRequest, Notification.class);
                notification.setUser(user);
                notificationList.add(notification);
            }
            notificationSaved = notificationRepository.saveAll(notificationList);
        }
        else{
            User user = userRepository.findById(notificationRequest.getUser_id()).orElseThrow(() -> new ResourceNotFoundException("User", "id", notificationRequest.getUser_id()));
            Notification notification = mapper.map(notificationRequest, Notification.class);
            notification.setUser(user);
            notificationSaved.add(notificationRepository.save(notification));
        }

        return notificationSaved.stream().map(notification -> mapper.map(notification, NotificationResponse.class)).toList();
    }

    @Override
    public NotificationResponse getNotification(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification", "id", id));
        return mapper.map(notification, NotificationResponse.class);
    }

    @Override
    public Page<NotificationResponse> getAllNotifications(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Notification> notificationPage = notificationRepository.findAll(pageable);
        return notificationPage.map(notification -> mapper.map(notification, NotificationResponse.class));
    }

    @Override
    public Page<NotificationResponse> getAllNotificationsOfUser(int pageNo, int pageSize, String sortBy, String sortDir, Long id) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Notification> notificationPage = notificationRepository.findAllByUser_Id(id, pageable);
        return notificationPage.map(notification -> mapper.map(notification, NotificationResponse.class));
    }

    @Override
    public Page<NotificationResponse> searchNotifications(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Notification> notificationPage = notificationRepository.searchByTitleOrContentOrSummary(searchText, pageable);
        return notificationPage.map(notification -> mapper.map(notification, NotificationResponse.class));
    }

    @Override
    public NotificationResponse updateNotification(NotificationRequest notificationRequest) {
        Notification notification = notificationRepository.findById(notificationRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Notification", "id", notificationRequest.getId()));
        if (notification != null) {
            notification.setRecipientType(notificationRequest.getRecipientType());
            notification.setNotificationType(notificationRequest.getNotificationType());
            notification.setTitle(notificationRequest.getTitle());
            notification.setSummary(notificationRequest.getSummary());
            notification.setContent(notificationRequest.getContent());
            notification.setImage(notificationRequest.getImage());
            notification.setStatus(notificationRequest.getStatus());
            return mapper.map(notificationRepository.save(notification), NotificationResponse.class);
        }
        return null;
    }

    @Override
    public void deleteNotification(long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notification", "id", id));
        if (notification != null) {
            notification.setStatus(EntityStatus.DISABLED);
            notificationRepository.save(notification);
        }
    }
}
