package com.API.shopAPI.repository;

import com.API.shopAPI.model.UniversityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<UniversityModel, UUID> {
}
