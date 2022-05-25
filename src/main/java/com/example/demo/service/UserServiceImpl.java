package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long id) {
        User userDB = userRepository.findById(id).get();

        if (Objects.nonNull(user.getFirstName()) && !user.getFirstName().isEmpty()) {
            userDB.setFirstName(user.getFirstName());
        }

        if (Objects.nonNull(user.getLastName()) && !user.getLastName().isEmpty()) {
            userDB.setLastName(user.getLastName());
        }

        if (Objects.nonNull(user.getEmail()) && !user.getEmail().isEmpty()) {
            userDB.setEmail(user.getEmail());
        }

        if (Objects.nonNull(user.getPhoneNumber()) && !user.getPhoneNumber().isEmpty()) {
            userDB.setPhoneNumber(user.getPhoneNumber());
        }

        return userRepository.save(userDB);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
