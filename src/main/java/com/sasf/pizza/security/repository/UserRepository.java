package com.sasf.pizza.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.sasf.pizza.security.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {
    
}
