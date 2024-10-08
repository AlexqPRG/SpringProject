package com.API.shopAPI.service;

import com.API.shopAPI.model.HolidayModel;
import com.API.shopAPI.repository.HolidayRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InMemoryHolidayServiceImpl extends InMemoryAbstractService<HolidayModel, UUID, HolidayRepository> {
    private final HolidayRepository holidayRepository;

    public InMemoryHolidayServiceImpl(HolidayRepository jpaRepository, HolidayRepository holidayRepository) {
        super(jpaRepository);
        this.holidayRepository = holidayRepository;
    }
}
