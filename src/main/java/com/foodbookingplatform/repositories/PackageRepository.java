package com.foodbookingplatform.repositories;

import com.foodbookingplatform.models.entities.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Long> {
}
