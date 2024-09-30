package com.web_project.shop.repository;

import com.web_project.shop.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemModel,Long> {
}
