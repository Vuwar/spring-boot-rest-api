package com.example.spring_boot_rest_api.repositories;

import com.example.spring_boot_rest_api.model.WorkspaceType;
import com.example.spring_boot_rest_api.entities.Workspace;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceRepository extends GenericRepository<Workspace, Long> {
    List<Workspace> findByAvailableTrue();

    List<Workspace> findByType(WorkspaceType type);
}
