package com.foodbookingplatform.models.payload.dto.category;

import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String image;
    private String name;
    private EntityStatus status;
//    private String createdBy;
//    private LocalDateTime createdDate;
//    private String modifiedBy;
//    private Set<Location> locations;
}
