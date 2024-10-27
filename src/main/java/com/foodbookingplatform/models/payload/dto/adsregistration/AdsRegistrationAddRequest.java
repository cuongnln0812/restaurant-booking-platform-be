package com.foodbookingplatform.models.payload.dto.adsregistration;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdsRegistrationAddRequest {
    @NotNull(message = "LocationId cannot be null")
    private Long locationId;

    @NotNull(message = "AdsId cannot be null")
    private Long adsId;

    private String bannerImage;
}
