package com.foodbookingplatform.models.payload.dto.adsregistration;

import com.foodbookingplatform.models.payload.dto.location.LocationResponseLazy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdsRegistrationLocationResponse {
    private LocationResponseLazy location;

    private List<AdsRegistrationResponse> adsResponses;
}
