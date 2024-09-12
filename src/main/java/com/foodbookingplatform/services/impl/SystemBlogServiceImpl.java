package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Category;
import com.foodbookingplatform.models.entities.SystemBlog;
import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.exception.MotherLoveApiException;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.category.CategoryResponse;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import com.foodbookingplatform.repositories.SystemBlogRepository;
import com.foodbookingplatform.services.SystemBlogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemBlogServiceImpl implements SystemBlogService {

    private final SystemBlogRepository systemBlogRepository;
    private final ModelMapper mapper;

    @Override
    public List<SystemBlogResponse> getAllSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<SystemBlog> systemBlogPage = systemBlogRepository.findAll(pageable);
        List<SystemBlog> systemBlogs = systemBlogPage.getContent();
        return systemBlogs.stream().map(systemBlog -> mapper.map(systemBlog, SystemBlogResponse.class)).toList();
    }

    @Override
    public List<SystemBlogResponse> searchSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir, String keyword) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<SystemBlog> systemBlogPage = systemBlogRepository.searchSystemBlogByTitleContainingIgnoreCase(keyword, pageable);
        List<SystemBlog> systemBlogs = systemBlogPage.getContent();
        return systemBlogs.stream().map(systemBlog -> mapper.map(systemBlog, SystemBlogResponse.class)).toList();
    }

    @Override
    public SystemBlogResponse createSystemBlog(SystemBlogRequest blog) {
        SystemBlog newBlog = mapper.map(blog, SystemBlog.class);
        SystemBlog savedBlog = systemBlogRepository.save(newBlog);
        return mapper.map(savedBlog, SystemBlogResponse.class);
    }

    @Override
    public SystemBlogResponse updateSystemBlog(SystemBlogRequest blog) {
        SystemBlog existedBlog = systemBlogRepository.findById(blog.getId())
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", blog.getId()));
        if (existedBlog != null) {
            SystemBlog updatedCategory = mapper.map(blog, SystemBlog.class);
            return mapper.map(systemBlogRepository.save(updatedCategory), SystemBlogResponse.class);
        }else throw new MotherLoveApiException(HttpStatus.NOT_FOUND, "Blog is null");
    }

    @Override
    public SystemBlogResponse findById(Long id) {
        SystemBlog existedBlog = systemBlogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", id));
        return mapper.map(existedBlog, SystemBlogResponse.class);
    }

    @Override
    public SystemBlogResponse changeStatus(Long id) {
        SystemBlog existedBlog = systemBlogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", id));
        if (existedBlog.getStatus().equals(EntityStatus.ACTIVE)) {
            existedBlog.setStatus(EntityStatus.INACTIVE);
        } else {
            existedBlog.setStatus(EntityStatus.ACTIVE);
        }
        return mapper.map(systemBlogRepository.save(existedBlog), SystemBlogResponse.class);
    }
}
