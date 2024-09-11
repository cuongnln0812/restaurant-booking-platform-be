package com.foodbookingplatform.models.payload.dto.brand;

import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandResponse {
    private Long Id;
    private String name;
    private EntityStatus status;
    private String image;
//    private Set<Location> locations;
}
