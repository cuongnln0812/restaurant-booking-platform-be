package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogRequest;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import com.foodbookingplatform.services.SystemBlogService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/system-blogs")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bear Authentication")
public class SystemBlogController {

    private final SystemBlogService systemBlogService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping
    public ResponseEntity<Page<SystemBlogResponse>> getAllSystemBlogs(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return ResponseEntity.ok(systemBlogService.getAllSystemBlog(pageNo, pageSize, sortBy, sortDir));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping("/search")
    public ResponseEntity<Page<SystemBlogResponse>> searchSystemBlogs(
            @RequestParam(name = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(value = "status", required = false) List<OfferStatus> status,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "summary", required = false) String summary,
            @RequestParam(value = "title", required = false) Long title
    ) {
        Map<String, Object> keyword = new HashMap<>();

        if (status != null && !status.isEmpty()) keyword.put("status", status);
        if (startDate != null) keyword.put("startDate", startDate);
        if (endDate != null) keyword.put("endDate", endDate);
        if (content != null) keyword.put("content", content);
        if (summary != null) keyword.put("summary", summary);
        if (title != null) keyword.put("title", title);

        return ResponseEntity.ok(systemBlogService.searchSystemBlog(pageNo, pageSize, sortBy, sortDir, keyword));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @GetMapping("{id}")
    public ResponseEntity<SystemBlogResponse> getSystemBlog(@PathVariable Long id) {
        return ResponseEntity.ok(systemBlogService.findById(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 201 CREATE")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PostMapping
    public ResponseEntity<SystemBlogResponse> addSystemBlog(@RequestBody @Valid SystemBlogRequest request) {
        SystemBlogResponse response = systemBlogService.createSystemBlog(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        return new ResponseEntity<>(brandService.addBrand(request), HttpStatus.CREATED);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PutMapping("/approval/{id}")
    public ResponseEntity<SystemBlogResponse> approveBlog(@PathVariable Long id){
        return ResponseEntity.ok(systemBlogService.approveSystemBlog(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PutMapping("{id}/status")
    public ResponseEntity<SystemBlogResponse> changeStatus(@PathVariable Long id){
        return ResponseEntity.ok(systemBlogService.changeStatus(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @PutMapping
    public ResponseEntity<SystemBlogResponse> updateSystemBlog(@RequestBody @Valid SystemBlogRequest request) {
        return ResponseEntity.ok(systemBlogService.updateSystemBlog(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('SYSTEM_ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<SystemBlogResponse> deleteSystemBlog(@PathVariable Long id) {
        return ResponseEntity.ok(systemBlogService.deleteSystemBlog(id));
    }
}
