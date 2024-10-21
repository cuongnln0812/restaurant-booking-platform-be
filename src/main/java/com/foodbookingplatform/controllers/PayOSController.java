package com.foodbookingplatform.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foodbookingplatform.models.payload.dto.payos.CreatePaymentDTO;
import com.foodbookingplatform.services.PayOSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ObjectNode> createPaymentLink(@RequestBody CreatePaymentDTO createPaymentDTO) {
        return ResponseEntity.ok(payOSService.createPayment(createPaymentDTO));
    }

}
