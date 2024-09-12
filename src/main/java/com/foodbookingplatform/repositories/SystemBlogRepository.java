package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.SystemBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemBlogRepository extends JpaRepository<SystemBlog, Long> {

}
