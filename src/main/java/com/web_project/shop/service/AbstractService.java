package com.web_project.shop.service;

import java.util.List;

public interface AbstractService<T, ID> {

    public List<T> findAll();

    public T createNote(T model);
}
