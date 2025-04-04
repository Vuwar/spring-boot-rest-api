package com.example.spring_boot_rest_api.services;

import com.example.spring_boot_rest_api.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(User userDetails, Long id);
    void deleteUserById(Long id);
}
