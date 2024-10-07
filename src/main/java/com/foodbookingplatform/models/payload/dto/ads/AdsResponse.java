package com.foodbookingplatform.models.payload.dto.ads;

import com.foodbookingplatform.models.enums.AdsType;
import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdsResponse {
    private Long id;

    private String name;

    private float price;

    private String description;

    private AdsType type;

    private int level;

    private EntityStatus status;

    private String image;

    private int duration;
}
