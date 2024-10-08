package com.API.shopAPI.repository;

import com.API.shopAPI.model.HolidayModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HolidayRepository extends JpaRepository<HolidayModel, UUID> {
}
