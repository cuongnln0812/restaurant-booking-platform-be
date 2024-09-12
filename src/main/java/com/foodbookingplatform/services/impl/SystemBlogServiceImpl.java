package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogCreateRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogUpdateRequest;
import com.foodbookingplatform.repositories.SystemBlogRepository;
import com.foodbookingplatform.services.SystemBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SystemBlogServiceImpl implements SystemBlogService {

    private final SystemBlogRepository systemBlogRepository;


    @Override
    public void createSystemBlog(SystemBlogCreateRequest blog) {

    }

    @Override
    public void updateSystemBlog(SystemBlogUpdateRequest blog) {

    }

    @Override
    public void findById(Long id) {

    }

    @Override
    public void changeStatus(Long id) {

    }
}
