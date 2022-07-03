package com.carPartsShopManagement.service;

import com.carPartsShopManagement.entity.User;
import com.carPartsShopManagement.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User saveUser(UserRegistrationDto registrationDto);

    List<User> getAllUsers();

    User updateUser(User user, Long id);

    void deleteUser(Long id);

    User getUserById(Long id);

    User getUserByEmail(String email);
}
