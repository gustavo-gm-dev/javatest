package com.javatest.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatest.user.model.User;
import com.javatest.user.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserRepository user_repository;

    @GetMapping("/find")
    public List<User> consultAll() {
        return user_repository.findAll();
    }

    @PostMapping("/modify")
    public User modify(@RequestBody User obj){
        return user_repository.save(obj);
    }
}
