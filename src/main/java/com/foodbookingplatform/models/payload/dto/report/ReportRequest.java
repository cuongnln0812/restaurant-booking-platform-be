package com.foodbookingplatform.models.payload.dto.report;

import com.foodbookingplatform.models.enums.ReportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportRequest {
    private Long id;
    private ReportType reportType;
    private String content;
    private String contentAnswer;
    private String image;
    private boolean status;
    private Long reporterId;
    private Long answererId;
}
