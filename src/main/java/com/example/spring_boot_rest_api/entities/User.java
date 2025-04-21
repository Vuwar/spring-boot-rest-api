package com.example.spring_boot_rest_api.entities;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private String code;
}
