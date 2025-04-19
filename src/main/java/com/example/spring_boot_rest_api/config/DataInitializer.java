package com.example.spring_boot_rest_api.config;

import com.example.spring_boot_rest_api.entities.User;
import com.example.spring_boot_rest_api.enums.Role;
import com.example.spring_boot_rest_api.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            User admin = new User("admin", passwordEncoder.encode("admin123"));
            User user = new User("user", passwordEncoder.encode("user123"));
            userRepository.save(user);
            userRepository.save(admin);
        }
    }
}
