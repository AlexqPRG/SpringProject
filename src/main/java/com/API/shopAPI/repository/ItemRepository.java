package com.API.shopAPI.repository;

import com.API.shopAPI.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemModel, UUID> {
}
