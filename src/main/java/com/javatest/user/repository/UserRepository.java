package com.javatest.user.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.javatest.user.model.User;

public interface UserRepository extends ListCrudRepository<User, Integer>{
    
}
