package com.foodbookingplatform.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.payload.dto.payos.CreatePaymentDTO;
import com.foodbookingplatform.models.payload.dto.payos.WebhookUrlDTO;
import com.foodbookingplatform.services.PayOSService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pay-os/")
public class PayOSController {

    private final PayOSService payOSService;

    @PostMapping(path = "/create-payment-link")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasAnyRole('USER', 'LOCATION_ADMIN', 'SYSTEM_ADMIN')")
    public ResponseEntity<ObjectNode> createPaymentLink(@RequestBody @Valid CreatePaymentDTO createPaymentDTO) {
        return ResponseEntity.ok(payOSService.createPayment(createPaymentDTO));
    }

//    @PostMapping(path = "/confirm-webhook")
//    public ResponseEntity<ObjectNode> confirmWebhook(@RequestBody @Valid WebhookUrlDTO webhookUrlDTO) {
//        return ResponseEntity.ok(payOSService.confirmWebhook(webhookUrlDTO));
//    }

}
