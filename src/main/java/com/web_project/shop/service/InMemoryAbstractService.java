package com.web_project.shop.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public abstract class InMemoryAbstractService<T, ID, R extends JpaRepository<T, ID>> implements AbstractService<T, ID>{
    private final JpaRepository<T, ID> jpaRepository;

    public InMemoryAbstractService(R jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List findAll() {
        return jpaRepository.findAll(Sort.by("id"));
    }

    @Override
    public T createNote(T model){
        return jpaRepository.save(model);
    }
}
