package com.foodbookingplatform.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.entities.*;
import com.foodbookingplatform.models.enums.PaymentStatus;

import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryRequest;
import com.foodbookingplatform.models.payload.dto.paymenthistory.PaymentHistoryResponse;
import com.foodbookingplatform.repositories.*;
import com.foodbookingplatform.services.PaymentHistoryService;
import com.foodbookingplatform.utils.PaymentCodeGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import vn.payos.PayOS;
import vn.payos.type.Webhook;
import vn.payos.type.WebhookData;

import java.util.Optional;

@Service
public class PaymentHistoryServiceImpl extends BaseServiceImpl<PaymentHistory, PaymentHistoryRequest, PaymentHistoryResponse> implements PaymentHistoryService {
    private final PayOS payOS;
    private final PaymentHistoryRepository paymentHistoryRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final LocationBookingRepository locationBookingRepository;
    private final PayOSTransactionRepository transactionRepository;
    private final MonthlyCommissionPaymentRepository commissionPaymentRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public PaymentHistoryServiceImpl(PayOS payOS, PaymentHistoryRepository paymentHistoryRepository, PaymentMethodRepository paymentMethodRepository, LocationBookingRepository locationBookingRepository, PayOSTransactionRepository transactionRepository, MonthlyCommissionPaymentRepository commissionPaymentRepository, UserRepository userRepository, ModelMapper modelMapper) {
        super(paymentHistoryRepository, modelMapper, PaymentHistory.class, PaymentHistoryRequest.class, PaymentHistoryResponse.class);
        this.payOS = payOS;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.locationBookingRepository = locationBookingRepository;
        this.transactionRepository = transactionRepository;
        this.commissionPaymentRepository = commissionPaymentRepository;
        this.userRepository = userRepository;
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

    @Override
    @Transactional
    public ObjectNode payOsTransferHandler(@RequestBody ObjectNode body)
            throws JsonProcessingException, IllegalArgumentException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();
        Webhook webhookBody = objectMapper.treeToValue(body, Webhook.class);

        try {
            // Init Response
            response.put("error", 0);
            response.put("message", "Webhook delivered");
            response.set("data", null);

            WebhookData data = payOS.verifyPaymentWebhookData(webhookBody);
            System.out.println("PAYOS DATA WEBHOOK: " + data.getCode() + " " + data.getPaymentLinkId() + " " + data.getDesc());
            long orderCode = data.getOrderCode();

            long userId = PaymentCodeGenerator.getUserIdFromOrderCode(orderCode);
            int month = PaymentCodeGenerator.getLastMonthFromOrderCode(orderCode);
            int year = PaymentCodeGenerator.getLastYearFromOrderCode(orderCode);
            String paymentCode = PaymentCodeGenerator.getPaymentCodeFromOrderCode(orderCode);

            if(paymentCode.equals(PaymentCodeGenerator.getCOMMISSION_PAYMENT_CODE())) {
                Optional<MonthlyCommissionPayment> commissionPaymentOpt = commissionPaymentRepository.findByUserIdAndMonthAndYear(userId, month, year);
                if(commissionPaymentOpt.isPresent()) {
                    MonthlyCommissionPayment commissionPayment = commissionPaymentOpt.get();
                    commissionPayment.setPaid(true);
                    commissionPayment.setPaidAt(data.getTransactionDateTime());
                    commissionPaymentRepository.save(commissionPayment);
                }
            }

            User user = userRepository.findById(PaymentCodeGenerator.getUserIdFromOrderCode(data.getOrderCode()))
                    .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

            PayOSTransaction transaction = transactionRepository.save(mapToTransaction(data, user));
            user.getTransactions().add(transaction);
            userRepository.save(user);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", -1);
            response.put("message", e.getMessage());
            response.set("data", null);
            return response;
        }
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

    private PayOSTransaction mapToTransaction(WebhookData data, User user) {
        return PayOSTransaction.builder()
                .orderCode(data.getOrderCode())
                .amount(data.getAmount())
                .description(data.getDescription())
                .accountNumber(data.getAccountNumber())
                .reference(data.getReference())
                .transactionDateTime(data.getTransactionDateTime())
                .currency(data.getCurrency())
                .paymentLinkId(data.getPaymentLinkId())
                .code(data.getCode())
                .desc(data.getDesc())
                .counterAccountBankId(data.getCounterAccountBankId())
                .counterAccountBankName(data.getCounterAccountBankName())
                .counterAccountName(data.getCounterAccountName())
                .counterAccountNumber(data.getCounterAccountNumber())
                .virtualAccountName(data.getVirtualAccountName())
                .virtualAccountNumber(data.getVirtualAccountNumber())
                .user(user)
                .build();
    }

}
