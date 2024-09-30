package com.web_project.shop.service;

import java.util.List;

public interface AbstractService<T, Long> {

    public List<T> findAll();

    public T createNote(T model);

    public T findById(Long id);

    T updateNote(T model, Long id);

    void deleteNote(Long id);
}
