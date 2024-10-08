package com.API.shopAPI.service;

import com.API.shopAPI.model.OrderModel;
import com.API.shopAPI.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InMemoryOrderService extends InMemoryAbstractService<OrderModel, UUID, OrderRepository>{
    private final OrderRepository repository;
    public InMemoryOrderService(OrderRepository jpaRepository, OrderRepository repository) {
        super(jpaRepository);
        this.repository = repository;
    }
}
