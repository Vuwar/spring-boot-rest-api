package com.example.spring_boot_rest_api.controllers;

import com.example.spring_boot_rest_api.entities.User;
import com.example.spring_boot_rest_api.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management", description = "Operations related to Users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Operation(summary = "Get all users")
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @Operation(summary = "Get an user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userServiceImpl.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Create a new user")
    @PostMapping
    public User saveUser(@Valid @RequestBody User user) {
        return userServiceImpl.saveUser(user);
    }

    @Operation(summary = "Update an user by ID")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable Long id) {
        try {
            User updatedUser = userServiceImpl.updateUser(newUser, id);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Delete an user")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userServiceImpl.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
