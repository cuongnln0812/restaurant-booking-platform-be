package com.foodbookingplatform.service.impl;

import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogCreateRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogUpdateRequest;
import com.foodbookingplatform.repositories.SystemBlogRepository;
import com.foodbookingplatform.service.SystemBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemBlogServiceImpl implements SystemBlogService {
    private SystemBlogRepository systemBlogRepository;


    @Override
    public void createSystemBlog(SystemBlogCreateRequest blog) {

    }

    @Override
    public void updateSystemBlog(SystemBlogUpdateRequest blog) {

    }
}
