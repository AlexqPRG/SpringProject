package com.web_project.shop.repository;

import com.web_project.shop.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends JpaRepository<ItemModel,Long> {
}
