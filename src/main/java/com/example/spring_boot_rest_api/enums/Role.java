package com.example.spring_boot_rest_api.enums;

import java.util.Set;

public enum Role {
    ROLE_USER(Set.of("READ")),
    ROLE_ADMIN(Set.of("READ", "WRITE", "UPDATE", "DELETE"));

    private final Set<String> authorities;

    Role(Set<String> authorities) {
        this.authorities = authorities;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }
}
