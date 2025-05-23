package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
