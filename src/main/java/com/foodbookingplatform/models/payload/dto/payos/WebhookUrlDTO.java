package com.foodbookingplatform.models.payload.dto.payos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebhookUrlDTO {
    @NotBlank(message = "Webhook Url cannot be blank")
    private String webhookUrl;
}
