package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SystemBlogService {
    Page<SystemBlogResponse> getAllSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<SystemBlogResponse> searchSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir, String keyword);
    SystemBlogResponse createSystemBlog(SystemBlogRequest blog);
    SystemBlogResponse updateSystemBlog(SystemBlogRequest blog);
    SystemBlogResponse approveSystemBlog(Long id);
    SystemBlogResponse findById(Long id);
    SystemBlogResponse changeStatus(Long id);
    SystemBlogResponse deleteSystemBlog(Long id);
}
