package com.foodbookingplatform.models.payload.dto.location;

import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.payload.dto.brand.BrandResponse;
import com.foodbookingplatform.models.payload.dto.category.CategoryResponse;
import com.foodbookingplatform.models.payload.dto.tag.TagResponse;
import com.foodbookingplatform.models.payload.dto.user.UserResponse;
import com.foodbookingplatform.models.payload.dto.workinghour.WorkingHourResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private int suggest;

    private boolean sale;

    private String latitude;

    private String longitude;

    private String description;

    private EntityStatus status;

    private String image;

    private UserResponse user;

    private BrandResponse brand;

    private List<CategoryResponse> category;

    private List<TagResponse> tag;

    private List<WorkingHourResponse> workingHour;
}
