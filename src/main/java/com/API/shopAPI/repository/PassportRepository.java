package com.API.shopAPI.repository;

import com.API.shopAPI.model.PassportModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PassportRepository extends JpaRepository<PassportModel, UUID> {
}
