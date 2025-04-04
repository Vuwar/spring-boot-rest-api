package com.example.spring_boot_rest_api.entities;

import com.example.spring_boot_rest_api.model.WorkspaceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "workspaces")
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @Enumerated(EnumType.STRING)
    private WorkspaceType type;
    private boolean available;

    @Lob
    private String description;

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("workspace")
    private List<Reservation> reservations;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }
}
