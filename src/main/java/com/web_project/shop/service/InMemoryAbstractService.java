package com.web_project.shop.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class InMemoryAbstractService<T, Long, R extends JpaRepository<T, Long>> implements AbstractService<T, Long>{
    private final JpaRepository<T, Long> jpaRepository;

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

    @Override
    public T findById(Long id){
        return jpaRepository.findById(id).orElse(null);
    }

    @Override
    public T updateNote(T model, Long id){
        if(jpaRepository.existsById(id)){
            return jpaRepository.save(model);
        }
        return null;
    }

    @Override
    public void deleteNote(Long id){
        if(jpaRepository.existsById(id)){
            jpaRepository.deleteById(id);
        }
    }
}
