package com.foodbookingplatform.models.payload.dto.location;

import com.foodbookingplatform.models.payload.dto.brand.BrandResponse;
import com.foodbookingplatform.models.payload.dto.category.CategoryResponse;
import com.foodbookingplatform.models.payload.dto.tag.TagResponse;
import com.foodbookingplatform.models.payload.dto.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private boolean suggest;

    private boolean sale;

    private String latitude;

    private String longitude;

    private LocalTime openingHours;

    private LocalTime closingHours;

    private String description;

    private String image;

    private UserResponse user;

    private BrandResponse brand;

    private List<CategoryResponse> category;

    private List<TagResponse> tag;
}
