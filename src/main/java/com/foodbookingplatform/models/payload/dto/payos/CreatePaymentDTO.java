package com.foodbookingplatform.models.payload.dto.payos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentDTO {
    private String productName;
    private String description;
    private int price;
    private String returnUrl;
    private String cancelUrl;
}
