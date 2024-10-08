package com.API.shopAPI.repository;

import com.API.shopAPI.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
    boolean existsByUsername(String username);
}
