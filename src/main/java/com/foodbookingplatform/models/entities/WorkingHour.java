package com.foodbookingplatform.models.entities;

import com.foodbookingplatform.models.enums.DayInWeek;
import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "working_hour")
public class WorkingHour extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_hour_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private DayInWeek day;
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;
    @Column(nullable = false)
    private EntityStatus status;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
}
