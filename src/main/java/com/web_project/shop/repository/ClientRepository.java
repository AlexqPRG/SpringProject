package com.web_project.shop.repository;

import com.web_project.shop.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
}
