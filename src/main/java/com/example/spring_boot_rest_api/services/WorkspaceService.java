package com.example.spring_boot_rest_api.services;

import com.example.spring_boot_rest_api.model.WorkspaceType;
import com.example.spring_boot_rest_api.entities.Workspace;

import java.util.List;

public interface WorkspaceService {
    List<Workspace> getAvailableWorkspaces();
    Workspace getWorkspaceById(Long id);
    List<Workspace> getWorkspacesByType(WorkspaceType type);
}
