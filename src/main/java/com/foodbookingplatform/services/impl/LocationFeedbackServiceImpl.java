package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Location;
import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.entities.LocationFeedback;
import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.enums.LocationBookingStatus;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.payload.dto.feedback.LocationFeedbackRequest;
import com.foodbookingplatform.models.payload.dto.feedback.LocationFeedbackResponse;
import com.foodbookingplatform.repositories.LocationBookingRepository;
import com.foodbookingplatform.repositories.LocationFeedbackRepository;
import com.foodbookingplatform.repositories.LocationRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.LocationFeedbackService;
import com.foodbookingplatform.utils.GenericSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LocationFeedbackServiceImpl implements LocationFeedbackService {
    private final UserRepository userRepository;
    private final LocationBookingRepository bookingRepository;
    private final LocationFeedbackRepository feedbackRepository;
    private final LocationRepository locationRepository;

    @Override
    @Transactional
    public LocationFeedbackResponse createFeedback(LocationFeedbackRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        LocationBooking booking = bookingRepository.findById(request.getLocationBookingId())
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", request.getLocationBookingId()));
        if(!booking.getStatus().equals(LocationBookingStatus.SUCCESSFUL))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST,  "You are not allowed to rate this booking!");

        LocationFeedback locationFeedback = feedbackRepository.findByLocationBookingIdAndUserId(booking.getId(), user.getId());
        if(locationFeedback != null){
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST,  "This location booking has been feedback!");
        }

        LocationFeedback feedback = new LocationFeedback();
        feedback.setContent(request.getContent());
        feedback.setRating(request.getRating());
        feedback.setImage(request.getImage());
        feedback.setNumberOfGuest(booking.getNumberOfGuest());
        feedback.setFeedbackDate(LocalDate.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        feedback.setUser(user);
        feedback.setLocationBooking(booking);
        feedback = feedbackRepository.save(feedback);
        user.getLocationFeedbacks().add(feedback);
        booking.getLocationFeedbacks().add(feedback);
        bookingRepository.save(booking);
        userRepository.save(user);

        return mapToResponse(feedback);
    }

    @Override
    public Page<LocationFeedbackResponse> getAllFeedback( int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<LocationFeedback> feedbacks;

        if(!keyword.isEmpty()) {
            Specification<LocationFeedback> specification = specification(keyword);
            feedbacks = feedbackRepository.findAll(specification, pageable);
        }else {
            feedbacks = feedbackRepository.findAll(pageable);
        }

        return feedbacks.map(this::mapToResponse);
    }

    @Override
    public Page<LocationFeedbackResponse> getAllFeedbackOfLocation(Long locationId, int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword){
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<LocationFeedback> feedbacks;

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new ResourceNotFoundException("Location", "locationId", locationId));

        if(!keyword.isEmpty()) {
            Specification<LocationFeedback> locationSpec = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("locationBooking").get("location"), location);
            Specification<LocationFeedback> keywordSpec = specification(keyword);
            Specification<LocationFeedback> combinedSpec = Specification.where(locationSpec).and(keywordSpec);
            feedbacks = feedbackRepository.findAll(combinedSpec, pageable);
        }else {
            feedbacks = feedbackRepository.findAllByLocationBookingLocation(location, pageable);
        }

        return feedbacks.map(this::mapToResponse);
    }

    @Override
    public Page<LocationFeedbackResponse> getAllFeedbackOfUser(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<LocationFeedback> feedbacks;

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        if(!keyword.isEmpty()) {
            Specification<LocationFeedback> locationSpec = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("user"), user);
            Specification<LocationFeedback> keywordSpec = specification(keyword);
            Specification<LocationFeedback> combinedSpec = Specification.where(locationSpec).and(keywordSpec);
            feedbacks = feedbackRepository.findAll(combinedSpec, pageable);
        }else {
            feedbacks = feedbackRepository.findAllByUser(user, pageable);
        }

        return feedbacks.map(this::mapToResponse);
    }


    @Override
    public LocationFeedbackResponse getFeedbackById(Long id) {
        LocationFeedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", id));
        return mapToResponse(feedback);
    }

    @Override
    public LocationFeedbackResponse getFeedbackByLocationBookingId(Long locationBookingId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));


        LocationFeedback feedback = feedbackRepository.findByLocationBookingId(locationBookingId);
        if(feedback == null){
            throw new ResourceNotFoundException("Feedback", "id", locationBookingId);
        }

        if(user.getRole().getName().equals("USER") && !user.equals(feedback.getUser()))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You are not allow to delete this feedback");
        return mapToResponse(feedback);
    }

    @Override
    public LocationFeedbackResponse updateFeedback(LocationFeedbackRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        LocationFeedback feedback = feedbackRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", request.getId()));
        if(feedback.isEdited())
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You cannot edit this feedback: Already edited!");
        if(!feedback.getUser().equals(user))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You cannot edit this feedback: Not the owner of this feedback!");
        feedback.setContent(request.getContent());
        feedback.setImage(request.getImage());
        feedback.setRating(request.getRating());
        feedback.setFeedbackDate(LocalDate.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        feedback.setEdited(true);
        feedback = feedbackRepository.save(feedback);
        return mapToResponse(feedback);
    }

    @Override
    @Transactional
    public String deleteFeedback(Long id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        LocationFeedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", id));
        if(user.getRole().getName().equals("USER") && !user.equals(feedback.getUser()))
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "You are not allow to delete this feedback");
        feedbackRepository.delete(feedback);
        return "Feedback with ID " + id + " has been deleted successfully.";
    }

    private Specification<LocationFeedback> specification(Map<String, Object> filters) {
        List<Specification<LocationFeedback>> specs = new ArrayList<>();

        filters.forEach((key, value) -> {
            switch (key) {
                case "feedbackDateFrom", "feedbackDateTo" -> {
                    LocalDate feedbackDateFrom = (LocalDate) filters.get("feedbackDateFrom");
                    LocalDate feedbackDateTo = (LocalDate) filters.get("feedbackDateTo");
                    if (feedbackDateFrom != null && feedbackDateTo != null) {
                        specs.add(GenericSpecification.fieldBetween("feedbackDate", feedbackDateFrom, feedbackDateTo));
                    } else if (feedbackDateFrom != null) {
                        specs.add(GenericSpecification.fieldGreaterThan("feedbackDate", feedbackDateFrom.minusDays(1)));
                    } else if (feedbackDateTo != null) {
                        specs.add(GenericSpecification.fieldLessThan("feedbackDate", feedbackDateTo.plusDays(1)));
                    }
                }
                case "minRating" -> specs.add(GenericSpecification.fieldGreaterThan("rating", (Integer) value - 1));
                case "maxRating" -> specs.add(GenericSpecification.fieldLessThan("rating", (Integer) value + 1));
                case "locationName" -> specs.add(
                        GenericSpecification.leftJoinFieldContains("locationBooking", "location", "name", (String) value)
                );
                case "userFullName" -> specs.add(GenericSpecification.joinFieldContains("user", "fullName", (String) value));
                case "content" -> specs.add(GenericSpecification.fieldContains("content", (String) value));
                case "numberOfGuestFrom" -> specs.add(GenericSpecification.fieldGreaterThan("numberOfGuest", (Integer) value - 1));
                case "numberOfGuestTo" -> specs.add(GenericSpecification.fieldLessThan("numberOfGuest", (Integer) value + 1));
            }
        });

        return specs.stream().reduce(Specification.where(null), Specification::and);
    }



    private LocationFeedbackResponse mapToResponse(LocationFeedback feedback){
        LocationFeedbackResponse response = new LocationFeedbackResponse();
        response.setId(feedback.getId());
        response.setContent(feedback.getContent());
        response.setRating(feedback.getRating());
        response.setImage(feedback.getImage());
        response.setFeedbackDate(feedback.getFeedbackDate());
        response.setNumberOfGuest(feedback.getNumberOfGuest());
        response.setLocationName(feedback.getLocationBooking().getLocation().getName());
        response.setUserName(feedback.getUser().getFullName());
        response.setLocationBookingId(feedback.getLocationBooking().getId());
        return response;
    }
}
