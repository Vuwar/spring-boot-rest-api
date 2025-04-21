//package com.example.spring_boot_rest_api.services.impl;
//
//import com.example.spring_boot_rest_api.exceptions.EntityNotFoundException;
//import com.example.spring_boot_rest_api.repositories.UserRepository;
//import com.example.spring_boot_rest_api.entities.User;
//import com.example.spring_boot_rest_api.services.UserService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final PasswordEncoder passwordEncoder;
//    private final UserRepository userRepository;
//
//    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }
//
//    @Transactional
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Transactional
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    @Transactional
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Transactional
//    public User updateUser(User userDetails, Long id) {
//        return userRepository.findById(id).map(user -> {
//            user.setUsername(userDetails.getUsername());
//            user.setPassword(userDetails.getPassword());
//            return userRepository.save(user);
//        }).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
//    }
//
//    @Transactional
//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public User getUserByName(String username) {
//        System.out.println("Looking up user: " + username);
//        return userRepository.findByUsername(username)
//                .orElseThrow(() -> new EntityNotFoundException("User not found with name: " + username));
//    }
//
//    public void registerUser(String username, String password, String role) {
//        String encodedPassword = passwordEncoder.encode(password);
//        User user = new User();
//        user.setName(username);
//        user.setPassword(encodedPassword);
//        user.setRole(role);
//        userRepository.save(user);
//    }
//}
