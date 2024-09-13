package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    @Query("SELECT n FROM Notification n WHERE n.title LIKE %:searchText% OR n.content LIKE %:searchText% OR n.summary LIKE %:searchText%")
    Page<Notification> searchByTitleOrContentOrSummary(@Param("searchText") String searchText, Pageable pageable);
    Page<Notification> findAllByUser_Id(Long id, Pageable pageable);
}
