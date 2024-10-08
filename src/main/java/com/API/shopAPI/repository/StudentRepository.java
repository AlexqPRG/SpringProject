package com.API.shopAPI.repository;

import com.API.shopAPI.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
}
