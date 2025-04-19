package com.example.spring_boot_rest_api.entities;

import com.example.spring_boot_rest_api.enums.Permission;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private Permission name;
}
