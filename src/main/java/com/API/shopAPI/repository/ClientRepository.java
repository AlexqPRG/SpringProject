package com.API.shopAPI.repository;

import com.API.shopAPI.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
}
