package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody UserRegistrationDto user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
