package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.entities.PaymentHistory;
import com.foodbookingplatform.models.entities.PaymentMethod;
import com.foodbookingplatform.models.enums.PaymentStatus;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryRequest;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryResponse;
import com.foodbookingplatform.repositories.LocationBookingRepository;
import com.foodbookingplatform.repositories.PaymentHistoryRepository;
import com.foodbookingplatform.repositories.PaymentMethodRepository;
import com.foodbookingplatform.services.PaymentHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PaymentHistoryServiceImpl extends BaseServiceImpl<PaymentHistory, PaymentHistoryRequest, PaymentHistoryResponse> implements PaymentHistoryService {
    private final PaymentHistoryRepository paymentHistoryRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final LocationBookingRepository locationBookingRepository;
    private final ModelMapper mapper;

    public PaymentHistoryServiceImpl(PaymentHistoryRepository paymentHistoryRepository, PaymentMethodRepository paymentMethodRepository, LocationBookingRepository locationBookingRepository, ModelMapper modelMapper) {
        super(paymentHistoryRepository, modelMapper, PaymentHistory.class, PaymentHistoryRequest.class, PaymentHistoryResponse.class);
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.locationBookingRepository = locationBookingRepository;
        this.mapper = modelMapper;
    }

    @Override
    public Page<PaymentHistoryResponse> getAllByLocationId(Long locationId, int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<PaymentHistory> pageResult = paymentHistoryRepository.findAllByLocationId(locationId, pageable);
        return pageResult.map(entity -> mapper.map(entity, PaymentHistoryResponse.class));
    }

    @Override
    public PaymentHistoryResponse add(PaymentHistoryRequest request) {
        request.setStatus(PaymentStatus.NEED_CONFIRMATION);
        PaymentHistory paymentHistory = mapAndSavePaymentHistory(request, true);
        return mapper.map(paymentHistory, PaymentHistoryResponse.class);
    }

    @Override
    public PaymentHistoryResponse update(PaymentHistoryRequest request) {
        PaymentHistory checkExist = paymentHistoryRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("PaymentHistory", "id", request.getId()));
        if (checkExist != null) {
            PaymentHistory paymentHistory = mapAndSavePaymentHistory(request, false);
            return mapper.map(paymentHistory, PaymentHistoryResponse.class);
        }
        return null;
    }

    private PaymentHistory mapAndSavePaymentHistory(PaymentHistoryRequest request, boolean createMode) {
        PaymentMethod paymentMethod = findPaymentMethodById(request.getPaymentMethodId());
        LocationBooking locationBooking = findLocationBookingById(request.getLocationBookingId());
        PaymentHistory checkUpdateDuplicate = paymentHistoryRepository.findPaymentHistoryByLocationBookingId(request.getLocationBookingId());
        if (createMode && locationBooking != null && checkUpdateDuplicate != null) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "The payment of this location booking has already been saved!");
        }

        if (!createMode && locationBooking != null && checkUpdateDuplicate != null && !checkUpdateDuplicate.getId().equals(request.getId())) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "The payment of this location booking has already been saved!");
        }

        PaymentHistory paymentHistory = mapper.map(request, PaymentHistory.class);
        paymentHistory.setLocationBooking(locationBooking);
        paymentHistory.setPaymentMethod(paymentMethod);

        return paymentHistoryRepository.save(paymentHistory);
    }

    private LocationBooking findLocationBookingById(Long locationBookingId) {
        return locationBookingRepository.findById(locationBookingId)
                .orElseThrow(() -> new ResourceNotFoundException("LocationBooking", "id", locationBookingId));
    }

    private PaymentMethod findPaymentMethodById(Long paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId)
                .orElseThrow(() -> new ResourceNotFoundException("PaymentMethod", "id", paymentMethodId));
    }
}
