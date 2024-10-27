package com.foodbookingplatform.services;

import com.foodbookingplatform.models.entities.LocationFeedback;
import com.foodbookingplatform.models.payload.dto.feedback.LocationFeedbackRequest;
import com.foodbookingplatform.models.payload.dto.feedback.LocationFeedbackResponse;
import org.springframework.data.domain.Page;

import java.nio.file.AccessDeniedException;
import java.util.Map;

public interface LocationFeedbackService {
    LocationFeedbackResponse createFeedback(LocationFeedbackRequest request);
    Page<LocationFeedbackResponse> getAllFeedback( int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword);
    Page<LocationFeedbackResponse> getAllFeedbackOfLocation(Long locationId, int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword) throws AccessDeniedException;
    Page<LocationFeedbackResponse> getAllFeedbackOfUser(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword);
    LocationFeedbackResponse getFeedbackById(Long id);
    String deleteFeedback(Long id);

}
