package com.foodbookingplatform.models.payload.dto.report;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.enums.ReportType;
import com.foodbookingplatform.models.payload.dto.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {
    private Long id;
    private ReportType reportType;
    private String content;
    private String contentAnswer;
    private String image;
    private boolean status;
//    private Long reporterId;
    private UserResponse reporter;
//    private Long answererId;
    private UserResponse answerer;
    private LocalDateTime createdDate;
}
