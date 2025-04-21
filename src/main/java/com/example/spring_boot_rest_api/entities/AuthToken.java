//package com.example.spring_boot_rest_api.entities;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Data
//public class AuthToken {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String token;
//
//    private LocalDateTime createdAt;
//    private LocalDateTime expiresAt;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private User user;
//
//}
