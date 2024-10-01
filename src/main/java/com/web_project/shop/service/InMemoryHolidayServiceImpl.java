package com.web_project.shop.service;

import com.web_project.shop.model.ClientModel;
import com.web_project.shop.model.HolidayModel;
import com.web_project.shop.repository.ClientRepository;
import com.web_project.shop.repository.HolidayRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryHolidayServiceImpl extends InMemoryAbstractService<HolidayModel, UUID, HolidayRepository> {
    private final HolidayRepository holidayRepository;

    public InMemoryHolidayServiceImpl(HolidayRepository jpaRepository, HolidayRepository holidayRepository) {
        super(jpaRepository);
        this.holidayRepository = holidayRepository;
    }
}
