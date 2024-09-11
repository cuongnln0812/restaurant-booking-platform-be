package com.foodbookingplatform.models.payload.dto.category;

import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String image;
    private String status;
    private EntityStatus name;
    private String createdBy;
    private LocalDateTime createdDate;
    private String modifiedBy;
//    private Set<Location> locations;
}
