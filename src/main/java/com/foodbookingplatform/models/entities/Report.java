package com.foodbookingplatform.models.entities;

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
@Table(name = "report")
public class Report extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_type", nullable = false)
    private int reportType;

    @Column(nullable = false)
    private String content;

    @Column(name = "content_answer")
    private String contentAnswer;

    @Column(name = "report_date", nullable = false)
    private LocalDateTime reportDate;

    @Column(nullable = false, length = Length.LOB_DEFAULT)
    private String image;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "reporter_Id", referencedColumnName = "Id", nullable = false)
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "answerer_Id", referencedColumnName = "Id")
    private User answerer;
}

