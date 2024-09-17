package com.foodbookingplatform.models.payload.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private Long id;

    private String addressLine;

    private String district;

    private String city;
}
