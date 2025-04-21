//package com.example.spring_boot_rest_api.controllers;
//
//import com.example.spring_boot_rest_api.entities.User;
//import com.example.spring_boot_rest_api.services.UserService;
//import com.example.spring_boot_rest_api.services.impl.UserServiceImpl;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.Mapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/user")
//public class UserProfileController {
//
//    private final UserServiceImpl userServiceImpl;
//
//    public UserProfileController(UserServiceImpl userServiceImpl) {
//        this.userServiceImpl = userServiceImpl;
//    }
//
//    @GetMapping("/me")
//    public ResponseEntity<User> getAuthenticatedUser(Authentication authentication) {
//        String username = authentication.getName();
//        User user = userServiceImpl.getUserByName(username);
//        return ResponseEntity.ok(user);
//    }
//
//}
