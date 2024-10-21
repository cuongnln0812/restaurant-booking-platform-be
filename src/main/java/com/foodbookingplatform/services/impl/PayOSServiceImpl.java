package com.foodbookingplatform.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.payload.dto.payos.CreatePaymentDTO;
import com.foodbookingplatform.models.payload.dto.payos.ItemDTO;
import com.foodbookingplatform.models.payload.dto.payos.WebhookUrlDTO;
import com.foodbookingplatform.services.PayOSService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import vn.payos.PayOS;
import vn.payos.type.CheckoutResponseData;
import vn.payos.type.ItemData;
import vn.payos.type.PaymentData;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Service
@Transactional
public class PayOSServiceImpl implements PayOSService {
    private final PayOS payOS;
    @Value("${payos.expired-time-minutes}")
    private String EXPIRED_TIME;

    public PayOSServiceImpl(PayOS payOS) {
        super();
        this.payOS = payOS;
    }
    @Override
    public ObjectNode createPayment(CreatePaymentDTO createPaymentDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ItemData> itemList;
        ObjectNode response = objectMapper.createObjectNode();
        try {
            final String buyerName = createPaymentDTO.getBuyerName();
            final String buyerPhone = createPaymentDTO.getBuyerPhone();
            final String description = createPaymentDTO.getDescription();
            final String returnUrl = createPaymentDTO.getReturnUrl();
            final String cancelUrl = createPaymentDTO.getCancelUrl();
            final Integer amount = createPaymentDTO.getItems().stream()
                    .map(ItemDTO::getPrice)
                    .reduce(0, Integer::sum);

            String currentTimeString = (String.valueOf(new Date().getTime()));
            long orderCode = Long.parseLong(currentTimeString.substring(currentTimeString.length() - 6));

            //UnixTimestamp
            Instant now = Instant.now();
            Instant expirationTime = now.plus(Duration.ofMinutes(Long.parseLong(EXPIRED_TIME)));
            long expirationTimestamp = expirationTime.getEpochSecond();

            itemList = createPaymentDTO.getItems().stream().map(dto -> ItemData.builder()
                            .name(dto.getName())
                            .price(dto.getPrice())
                            .quantity(dto.getQuantity())
                            .build()).toList();

            PaymentData paymentData = PaymentData.builder()
                    .orderCode(orderCode)
                    .description(description)
                    .buyerName(buyerName)
                    .buyerPhone(buyerPhone)
                    .amount(amount)
                    .returnUrl(returnUrl)
                    .cancelUrl(cancelUrl)
                    .expiredAt(expirationTimestamp)
                    .build();
            paymentData.setItems(itemList);

            CheckoutResponseData data = payOS.createPaymentLink(paymentData);

            response.put("error", 0);
            response.put("status", "success");
            response.put("message", "Create payment link successfully" );
            response.set("data", objectMapper.valueToTree(data));
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", -1);
            response.put("status", "fail");
            response.put("message", e.getMessage());
            response.set("data", null);
            return response;
        }
    }

    @Override
    public ObjectNode confirmWebhook(WebhookUrlDTO requestBody) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();
        try {
            String str = payOS.confirmWebhook(requestBody.getWebhookUrl());
            response.set("data", objectMapper.valueToTree(str));
            response.put("error", 0);
            response.put("message", "ok");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", -1);
            response.put("message", e.getMessage());
            response.set("data", null);
            return response;
        }
    }

}
