package com.foodbookingplatform.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.payload.dto.payos.CreatePaymentDTO;
import com.foodbookingplatform.models.payload.dto.payos.WebhookUrlDTO;

public interface PayOSService {
    ObjectNode createPayment(CreatePaymentDTO createPaymentDTO);
    ObjectNode confirmWebhook(WebhookUrlDTO webhookUrlDTO);
}
