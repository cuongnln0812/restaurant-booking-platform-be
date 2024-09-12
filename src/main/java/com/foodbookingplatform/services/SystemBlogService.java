package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogCreateRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogUpdateRequest;

import java.util.List;

public interface SystemBlogService {
    List<SystemBlogResponse> getAllSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir);
    List<SystemBlogResponse> searchSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir, String keyword);
    SystemBlogResponse createSystemBlog(SystemBlogCreateRequest blog);
    SystemBlogResponse updateSystemBlog(SystemBlogUpdateRequest blog);
    SystemBlogResponse findById(Long id);
    SystemBlogResponse changeStatus(Long id);
}
