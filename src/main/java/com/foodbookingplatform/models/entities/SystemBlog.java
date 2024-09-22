package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.BlogStatus;
import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Length;
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
@Table(name = "system_blog")
public class SystemBlog extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String summary;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BlogStatus status;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @Column(name = "publish_date")
    private LocalDateTime publishDate;

    @ManyToOne
    @JoinColumn(name = "author_Id", referencedColumnName = "Id", nullable = false)
    private User user;
}
