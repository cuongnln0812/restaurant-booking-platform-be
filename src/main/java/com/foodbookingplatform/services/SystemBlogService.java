package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;

import java.util.List;

public interface SystemBlogService {
    List<SystemBlogResponse> getAllSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir);
    List<SystemBlogResponse> searchSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir, String keyword);
    SystemBlogResponse createSystemBlog(SystemBlogRequest blog);
    SystemBlogResponse updateSystemBlog(SystemBlogRequest blog);
    SystemBlogResponse findById(Long id);
    SystemBlogResponse changeStatus(Long id);
}
