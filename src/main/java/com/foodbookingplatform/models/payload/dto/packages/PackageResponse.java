package com.foodbookingplatform.models.payload.dto.packages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PackageResponse {
    private Long id;

    private String name;

    private float price;

    private String description;

    private String image;

    private int duration;
}
