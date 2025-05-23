package com.foodbookingplatform.models.payload.dto.location;

import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponseLazy {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private int onSuggest;

    private int onSale;

    private int onBanner;

    private int view;

    private int rating;

    private double latitude;

    private double longitude;

    private String distance;

    private String description;

    private EntityStatus status;

    private String image;

    private String bannerImage;

    private List<String> categoryName;

    private List<String> tagName;
}
