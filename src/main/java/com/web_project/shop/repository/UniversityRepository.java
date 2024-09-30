package com.web_project.shop.repository;

import com.web_project.shop.model.UniversityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<UniversityModel, UUID> {
}
