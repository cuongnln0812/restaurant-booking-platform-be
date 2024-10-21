package com.foodbookingplatform.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.payload.dto.payos.CreatePaymentDTO;
import com.foodbookingplatform.services.PayOSService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.payos.PayOS;
import vn.payos.type.CheckoutResponseData;
import vn.payos.type.ItemData;
import vn.payos.type.PaymentData;

import java.util.*;

@Service
@Transactional
public class PayOSServiceImpl implements PayOSService {
    private final PayOS payOS;

    public PayOSServiceImpl(PayOS payOS) {
        super();
        this.payOS = payOS;
    }
    @Override
    public ObjectNode createPayment(CreatePaymentDTO createPaymentDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode response = objectMapper.createObjectNode();
        try {
            final String productName = createPaymentDTO.getProductName();
            final String description = createPaymentDTO.getDescription();
            final String returnUrl = createPaymentDTO.getReturnUrl();
            final String cancelUrl = createPaymentDTO.getCancelUrl();
            final int price = createPaymentDTO.getPrice();
            // Gen order code
            String currentTimeString = (String.valueOf(new Date().getTime()));
            long orderCode = Long.parseLong(currentTimeString.substring(currentTimeString.length() - 6));

            ItemData item = ItemData.builder().name(productName).price(price).quantity(1).build();

            PaymentData paymentData = PaymentData.builder().orderCode(orderCode).description(description).amount(price)
                    .item(item).returnUrl(returnUrl).cancelUrl(cancelUrl).build();

            CheckoutResponseData data = payOS.createPaymentLink(paymentData);

            response.put("error", 0);
            response.put("message", "success");
            response.set("data", objectMapper.valueToTree(data));
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            response.put("error", -1);
            response.put("status", "fail");
//            response.put("code", e.getCode());
            response.put("message", e.getMessage());
            response.set("data", null);
            return response;
        }
    }
}
