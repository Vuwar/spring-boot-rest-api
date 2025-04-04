package com.example.spring_boot_rest_api.services.impl;

import com.example.spring_boot_rest_api.exceptions.EntityNotFoundException;
import com.example.spring_boot_rest_api.model.WorkspaceType;
import com.example.spring_boot_rest_api.entities.Workspace;
import com.example.spring_boot_rest_api.repositories.WorkspaceRepository;
import com.example.spring_boot_rest_api.services.WorkspaceService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceServiceImpl extends GenericServiceImpl<Workspace, Long> implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceServiceImpl(WorkspaceRepository workspaceRepository) {
        super(workspaceRepository);
        this.workspaceRepository = workspaceRepository;
    }

    @Transactional
    public List<Workspace> getAvailableWorkspaces() {
        return workspaceRepository.findByAvailableTrue();
    }

    @Transactional
    public Workspace getWorkspaceById(Long id) {
        return workspaceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Workspace not found"));
    }

    @Transactional
    public List<Workspace> getWorkspacesByType(WorkspaceType type) {
        return workspaceRepository.findByType(type);
    }
}
