package com.web_project.shop.repository;

import com.web_project.shop.model.PassportModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassportRepository extends JpaRepository<PassportModel, UUID> {
}
