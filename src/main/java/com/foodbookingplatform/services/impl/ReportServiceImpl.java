package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Report;
import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.report.ReportRequest;
import com.foodbookingplatform.models.payload.dto.report.ReportResponse;
import com.foodbookingplatform.repositories.ReportRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.ReportService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl extends BaseServiceImpl<Report, ReportRequest, ReportResponse> implements ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public ReportServiceImpl(ReportRepository reportRepository, UserRepository userRepository, ModelMapper modelMapper) {
        super(reportRepository, modelMapper, Report.class, ReportRequest.class, ReportResponse.class);
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.mapper = modelMapper;
    }

    @Override
    public ReportResponse add(ReportRequest request) {
        User reporter = userRepository.findById(request.getReporterId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", request.getReporterId()));
        User answerer = userRepository.findById(request.getAnswererId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", request.getAnswererId()));
        Report report = mapper.map(request, Report.class);
        report.setReporter(reporter);
        report.setAnswerer(answerer);
        report.setStatus(true);
        Report savedReport = reportRepository.save(report);
        return mapper.map(savedReport, ReportResponse.class);
    }

    @Override
    public List<ReportResponse> search(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Report> page = reportRepository.findReportsByContentContainingIgnoreCase(searchText, pageable);
        List<Report> listResponse = page.getContent();
        return listResponse.stream().map(res -> mapper.map(res, ReportResponse.class)).toList();
    }

    @Override
    public ReportResponse update(ReportRequest request) {
        User reporter = userRepository.findById(request.getReporterId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", request.getReporterId()));
        User answerer = userRepository.findById(request.getAnswererId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", request.getAnswererId()));
        Report report = mapper.map(request, Report.class);
        report.setReporter(reporter);
        report.setAnswerer(answerer);
        report.setStatus(request.isStatus());
        Report savedReport = reportRepository.save(report);
        return mapper.map(savedReport, ReportResponse.class);
    }
}
