package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import com.foodbookingplatform.services.SystemBlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/system-blogs")
@RequiredArgsConstructor
public class SystemBlogController {

    private final SystemBlogService systemBlogService;

    @GetMapping
    public ResponseEntity<Page<SystemBlogResponse>> getAllSystemBlogs(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(systemBlogService.getAllSystemBlog(pageNo, pageSize, sortBy, sortDir));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<SystemBlogResponse>> searchSystemBlogs(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(name = "keyword") String keyword
    ) {
        return ResponseEntity.ok(systemBlogService.searchSystemBlog(pageNo, pageSize, sortBy, sortDir, keyword));
    }

    @GetMapping("{id}")
    public ResponseEntity<SystemBlogResponse> getSystemBlog(@PathVariable Long id) {
        return ResponseEntity.ok(systemBlogService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SystemBlogResponse> addSystemBlog(@RequestBody @Valid SystemBlogRequest request) {
        SystemBlogResponse response = systemBlogService.createSystemBlog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        return new ResponseEntity<>(brandService.addBrand(request), HttpStatus.CREATED);
    }

    @PutMapping("/approval/{id}")
    public ResponseEntity<SystemBlogResponse> approveBlog(@PathVariable Long id){
        return ResponseEntity.ok(systemBlogService.approveSystemBlog(id));
    }

    @PutMapping("{id}/status")
    public ResponseEntity<SystemBlogResponse> changeStatus(@PathVariable Long id){
        return ResponseEntity.ok(systemBlogService.changeStatus(id));
    }

    @PutMapping
    public ResponseEntity<SystemBlogResponse> updateSystemBlog(@RequestBody @Valid SystemBlogRequest request) {
        return ResponseEntity.ok(systemBlogService.updateSystemBlog(request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SystemBlogResponse> deleteSystemBlog(@PathVariable Long id) {
        return ResponseEntity.ok(systemBlogService.deleteSystemBlog(id));
    }
}
