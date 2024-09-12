package com.foodbookingplatform.service;

import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogCreateRequest;

public interface SystemBlogService {

    void createSystemBlog(SystemBlogCreateRequest blog);
    void updateSystemBlog(SystemBlogUpdateRequest blog);
}
