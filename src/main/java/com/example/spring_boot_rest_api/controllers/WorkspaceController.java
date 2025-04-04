package com.example.spring_boot_rest_api.controllers;

import com.example.spring_boot_rest_api.model.WorkspaceType;
import com.example.spring_boot_rest_api.entities.Workspace;
import com.example.spring_boot_rest_api.services.impl.WorkspaceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspaces")
@Tag(name = "Workspace Management", description = "Operations related to Workspaces")
public class WorkspaceController {

    private final WorkspaceServiceImpl workspaceServiceImpl;

    public WorkspaceController(WorkspaceServiceImpl workspaceServiceImpl) {
        this.workspaceServiceImpl = workspaceServiceImpl;
    }

    @Operation(summary = "Get all available workspaces")
    @GetMapping("/available")
    public List<Workspace> getAvailableWorkspaces() {
        return workspaceServiceImpl.getAvailableWorkspaces();
    }

    @Operation(summary = "Get a workspace by ID")
    @GetMapping("/{id}")
    public Workspace getWorkspaceById(@PathVariable Long id) {
        return workspaceServiceImpl.getWorkspaceById(id);
    }

    @Operation(summary = "Create a new workspace")
    @PostMapping
    public Workspace createWorkspace(@Valid @RequestBody Workspace workspace) {
        return workspaceServiceImpl.save(workspace);
    }

//    @GetMapping("/all")
//    public List<Workspace> getAllWorkspaces() {
//        return workspaceService.findAll();
//    }

    @Operation(summary = "Get workspaces based on its type")
    @GetMapping("/all")
    public List<Workspace> getAllWorkspaces(@RequestParam(required = false) WorkspaceType type) {
        if (type != null) {
            return workspaceServiceImpl.getWorkspacesByType(type);
        }
        return workspaceServiceImpl.findAll();
    }
}
