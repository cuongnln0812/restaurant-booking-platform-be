package com.foodbookingplatform.models.payload.dto.payos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentDTO {
    private String buyerName;
    private String buyerPhone;
    @NotBlank(message = "Description cannot be blank!")
    @Size(min = 1, max = 25, message = "Description must be between 1 and 25 characters!")
    private String description;
    @NotEmpty(message = "Item list cannot be empty!")
    @Size(min = 1, message = "There must be at least 1 item!")
    private List<ItemDTO> items;
    @NotBlank(message = "Return Url cannot be blank!")
    private String returnUrl;
    @NotBlank(message = "Cancel Url cannot be blank!")
    private String cancelUrl;
}
