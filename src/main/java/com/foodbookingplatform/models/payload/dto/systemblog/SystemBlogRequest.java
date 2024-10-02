package com.foodbookingplatform.models.payload.dto.systemblog;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemBlogRequest {

    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Summary cannot be blank")
    private String summary;

    @NotBlank(message = "Content cannot be blank")
    private String content;

    @NotEmpty(message = "Image cannot be blank")
    private String image;

    private String createdBy;
}
