package com.foodbookingplatform.models.payload.dto.adsregistration;

import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.payload.dto.ads.AdsResponse;
import com.foodbookingplatform.models.payload.dto.location.LocationResponseLazy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdsRegistrationAddResponse {
    private Long id;

    private LocalDateTime registrationDate;

    private LocalDateTime expireDate;

    private OfferStatus status;

    private AdsResponse ads;

    private LocationResponseLazy location;
}
