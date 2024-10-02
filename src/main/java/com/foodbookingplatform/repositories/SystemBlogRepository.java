package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.SystemBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemBlogRepository extends JpaRepository<SystemBlog, Long>, JpaSpecificationExecutor<SystemBlog> {
}
