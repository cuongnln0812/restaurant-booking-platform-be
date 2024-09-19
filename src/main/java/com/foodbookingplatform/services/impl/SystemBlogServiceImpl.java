package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.SystemBlog;
import com.foodbookingplatform.models.enums.BlogStatus;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import com.foodbookingplatform.repositories.SystemBlogRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.SystemBlogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SystemBlogServiceImpl implements SystemBlogService {

    private final SystemBlogRepository systemBlogRepository;
    private final UserRepository userRepository;
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
    @Transactional
    public SystemBlogResponse createSystemBlog(SystemBlogRequest blog) {
        SystemBlog newBlog = mapper.map(blog, SystemBlog.class);
        newBlog.setStatus(BlogStatus.PENDING);
        //Khi nào có Security thì đổi lại
        newBlog.setUser(userRepository.findById(blog.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", blog.getAuthorId())));
        SystemBlog savedBlog = systemBlogRepository.save(newBlog);
        return mapper.map(savedBlog, SystemBlogResponse.class);
    }

    @Override
    @Transactional
    public SystemBlogResponse updateSystemBlog(SystemBlogRequest blog) {
        SystemBlog existedBlog = systemBlogRepository.findById(blog.getId())
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", blog.getId()));
        if(!existedBlog.getStatus().equals(BlogStatus.DISABLED)) {
            mapper.map(blog, existedBlog);
            return mapper.map(systemBlogRepository.save(existedBlog), SystemBlogResponse.class);
        }else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "This blog is not able to update!");
    }

    @Override
    public SystemBlogResponse approveSystemBlog(Long id) {
        SystemBlog existedBlog = systemBlogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", id));
        if(existedBlog.getStatus().equals(BlogStatus.PENDING)) existedBlog.setStatus(BlogStatus.ACTIVE);
        else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "This blog is not able for approval!");
        return mapper.map(systemBlogRepository.save(existedBlog), SystemBlogResponse.class);
    }

    @Override
    public SystemBlogResponse findById(Long id) {
        SystemBlog existedBlog = systemBlogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", id));
        return mapper.map(existedBlog, SystemBlogResponse.class);
    }

    @Override
    @Transactional
    public SystemBlogResponse changeStatus(Long id) {
        SystemBlog existedBlog = systemBlogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", id));
        if (existedBlog.getStatus().equals(BlogStatus.ACTIVE)) {
            existedBlog.setStatus(BlogStatus.INACTIVE);
        } else if(existedBlog.getStatus().equals(BlogStatus.INACTIVE)) {
            existedBlog.setStatus(BlogStatus.ACTIVE);
        } else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Only blogs with ACTIVE or INACTIVE status can perform this action!");
        return mapper.map(systemBlogRepository.save(existedBlog), SystemBlogResponse.class);
    }

    @Override
    @Transactional
    public SystemBlogResponse deleteSystemBlog(Long id) {
        SystemBlog existedBlog = systemBlogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("System Blog", "Id", id));
        if(!existedBlog.getStatus().equals(BlogStatus.DISABLED)){
            existedBlog.setStatus(BlogStatus.DISABLED);
        }else throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "This blog has been deleted or not existed!");
        return mapper.map(systemBlogRepository.save(existedBlog), SystemBlogResponse.class);
    }
}
