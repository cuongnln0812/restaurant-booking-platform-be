package com.foodbookingplatform.models.payload.dto.voucher;

import com.foodbookingplatform.models.enums.OfferStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoucherRequest {
    private Long id;

    @NotBlank(message = "Code cannot be blank!")
    @Size(min = 2, max = 10, message = "Code must have at least 2 characters and not greater than 10")
    private String code;

    @NotBlank(message = "Name cannot be blank!")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 2, message = "Description must have at least 2 characters")
    private String description;

    @NotNull(message = "Quantity cannot be blank!")
    @Min(value = 1, message = "Minimum value for quantity is 1")
    private int quantity;

    @NotNull(message = "Max quantity use cannot be blank!")
    @Min(value = 1, message = "Minimum value for quantity is 1")
    private int quantityUse;

    @NotNull(message = "Code cannot be blank!")
    private float discount;

    @NotNull(message = "Code cannot be blank!")
    private float minOrderAmount;

    @NotNull(message = "Max discount cannot be blank!")
    private int maxDiscountAmount;

    @NotNull(message = "Start Date cannot be blank!")
    private LocalDateTime startDate;

    @NotNull(message = "End Date cannot be blank!")
    private LocalDateTime endDate;
}
