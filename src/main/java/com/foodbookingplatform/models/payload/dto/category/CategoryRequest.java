package com.foodbookingplatform.models.payload.dto.category;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private Long id;
    @NotEmpty(message = "Category's image cannot be blank")
    @Size(min = 2, message = "Category's image must have at least 2 characters")
    private String image;

    @NotEmpty(message = "Category's name cannot be blank")
    @Size(min = 2, message = "Category's name must have at least 2 characters")
    private String name;

    private EntityStatus status;
}
