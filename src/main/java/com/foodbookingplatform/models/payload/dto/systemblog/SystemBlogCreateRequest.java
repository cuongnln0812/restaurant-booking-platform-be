package com.foodbookingplatform.models.payload.dto.systemblog;

import com.foodbookingplatform.models.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class SystemBlogCreateRequest {

    private String title;

    private String summary;

    private String content;

    private EntityStatus status;

    private String image;

}
