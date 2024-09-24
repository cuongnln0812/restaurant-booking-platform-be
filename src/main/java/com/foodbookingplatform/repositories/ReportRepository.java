package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Page<Report> findReportsByContentContainingIgnoreCase(String searchText, Pageable pageable);
}
