package com.carPartsShopManagement.service;

import com.carPartsShopManagement.entity.Role;
import com.carPartsShopManagement.entity.User;
import com.carPartsShopManagement.repository.UserRepository;
import com.carPartsShopManagement.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;

    public DefaultUserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(),
                registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(new Role("USER")));
        return userRepository.save(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
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

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
