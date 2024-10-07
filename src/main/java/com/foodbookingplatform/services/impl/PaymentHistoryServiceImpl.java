package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.LocationBooking;
import com.foodbookingplatform.models.entities.PaymentHistory;
import com.foodbookingplatform.models.entities.PaymentMethod;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryRequest;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryResponse;
import com.foodbookingplatform.repositories.LocationBookingRepository;
import com.foodbookingplatform.repositories.PaymentHistoryRepository;
import com.foodbookingplatform.repositories.PaymentMethodRepository;
import com.foodbookingplatform.services.PaymentHistoryService;
import org.modelmapper.ModelMapper;
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
    public PaymentHistoryResponse add(PaymentHistoryRequest request) {
        LocationBooking locationBooking = locationBookingRepository.findById(request.getLocationBookingId()).orElseThrow(() -> new ResourceNotFoundException("LocationBooking", "id", request.getLocationBookingId()));
        PaymentMethod paymentMethod = paymentMethodRepository.findById(request.getPaymentMethodId()).orElseThrow(() -> new ResourceNotFoundException("PaymentMethod", "id", request.getPaymentMethodId()));
        PaymentHistory paymentHistory = mapper.map(request, PaymentHistory.class);
        PaymentHistory savedPaymentHistory = paymentHistoryRepository.save(paymentHistory);
        return mapper.map(savedPaymentHistory, PaymentHistoryResponse.class);
    }

    @Override
    public PaymentHistoryResponse update(PaymentHistoryRequest request) {
        LocationBooking locationBooking = locationBookingRepository.findById(request.getLocationBookingId()).orElseThrow(() -> new ResourceNotFoundException("LocationBooking", "id", request.getLocationBookingId()));
        PaymentMethod paymentMethod = paymentMethodRepository.findById(request.getPaymentMethodId()).orElseThrow(() -> new ResourceNotFoundException("PaymentMethod", "id", request.getPaymentMethodId()));
        PaymentHistory paymentHistory = mapper.map(request, PaymentHistory.class);
        PaymentHistory savedPaymentHistory = paymentHistoryRepository.save(paymentHistory);
        return mapper.map(savedPaymentHistory, PaymentHistoryResponse.class);
    }
}
