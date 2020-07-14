package com.example.foreignkeybasedonetoone.controller;

import com.example.foreignkeybasedonetoone.model.User;
import com.example.foreignkeybasedonetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    public static final String USER = "/user";

    @Autowired
    private UserRepository userRepository;

    @GetMapping(USER)
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @PostMapping(USER)
    public User addUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

}
