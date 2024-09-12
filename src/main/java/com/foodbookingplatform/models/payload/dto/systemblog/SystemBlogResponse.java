package com.foodbookingplatform.models.payload.dto.systemblog;

import com.foodbookingplatform.models.enums.BlogStatus;
import com.foodbookingplatform.models.enums.EntityStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemBlogResponse {
    private Long id;

    private String title;

    private String summary;

    private String content;

    private String image;

    private String publishDate;

    private BlogStatus status;
}
