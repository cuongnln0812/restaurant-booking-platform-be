package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.SystemBlog;
import com.foodbookingplatform.models.entities.Voucher;
import com.foodbookingplatform.models.enums.BlogStatus;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import com.foodbookingplatform.repositories.SystemBlogRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.SystemBlogService;
import com.foodbookingplatform.utils.GenericSpecification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SystemBlogServiceImpl implements SystemBlogService {

    private final SystemBlogRepository systemBlogRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public Page<SystemBlogResponse> getAllSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<SystemBlog> systemBlogPage = systemBlogRepository.findAll(pageable);
        return systemBlogPage.map(systemBlog -> mapper.map(systemBlog, SystemBlogResponse.class));
    }

    @Override
    public Page<SystemBlogResponse> searchSystemBlog(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> keyword) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<SystemBlog> systemBlogs;

        if(!keyword.isEmpty()) {
            Specification<SystemBlog> specification = specification(keyword);
            systemBlogs = systemBlogRepository.findAll(specification, pageable);
        }else {
            systemBlogs = systemBlogRepository.findAll(pageable);
        }

        return systemBlogs.map(systemBlog -> mapper.map(systemBlog, SystemBlogResponse.class));
    }

    @Override
    @Transactional
    public SystemBlogResponse createSystemBlog(SystemBlogRequest blog) {

        SystemBlog newBlog = mapper.map(blog, SystemBlog.class);
        newBlog.setStatus(BlogStatus.PENDING);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        newBlog.setUser(userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username)));
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

    private Specification<SystemBlog> specification(Map<String, Object> searchParams){
        List<Specification<SystemBlog>> specs = new ArrayList<>();

        searchParams.forEach((key, value) -> {
            switch (key) {
                case "status":
                    specs.add(GenericSpecification.fieldIn(key, (Collection<?>) value));
                    break;
                case "startDate":
                    if (searchParams.containsKey("endDate")) {
                        specs.add(GenericSpecification.fieldBetween("publishDate", (LocalDateTime) searchParams.get("startDate"), (LocalDateTime) searchParams.get("endDate")));
                    } else {
                        specs.add(GenericSpecification.fieldGreaterThan("publishDate", (LocalDateTime) value));
                    }
                    break;
                case "endDate":
                    if (!searchParams.containsKey("startDate")) {
                        specs.add(GenericSpecification.fieldLessThan("publishDate", (LocalDateTime) value));
                    }
                    break;
                case "content":
                case "summary":
                case "title":
                    specs.add(GenericSpecification.fieldContains(key, (String) value));
                    break;
            }
        });

        return specs.stream().reduce(Specification.where(null), Specification::and);
    }
}
