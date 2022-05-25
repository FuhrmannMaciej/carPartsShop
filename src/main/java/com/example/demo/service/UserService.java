package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {

    User saveUser(UserRegistrationDto registrationDto);

    List<User> getAllUsers();

    User updateUser(User user, Long id);

    void deleteUser(Long id);

    User getUserById(Long id);

    User getUserByEmail(String email);
}
