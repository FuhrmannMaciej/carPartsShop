package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User updateUser(User user, Long id);

    void deleteUser(Long id);

    User getUserById(Long id);

    User getUserByEmail(String email);
}