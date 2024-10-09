package com.foodbookingplatform.models.payload.dto.systemblog;

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
    @Size(min = 2, message = "Title must have at least 2 characters")
    private String title;

    @NotBlank(message = "Summary cannot be blank")
    @Size(min = 2, message = "Summary must have at least 2 characters")
    private String summary;

    @NotBlank(message = "Content cannot be blank")
    @Size(min = 2, message = "Content must have at least 2 characters")
    private String content;

    @NotEmpty(message = "Image cannot be blank")
    private String image;
}
