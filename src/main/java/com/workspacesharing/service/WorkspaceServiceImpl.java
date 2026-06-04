package com.workspacesharing.service;

import com.workspacesharing.enums.WorkspaceStatus;
import com.workspacesharing.enums.WorkspaceType;
import com.workspacesharing.model.Workspace;
import com.workspacesharing.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements IWorkspaceService {
    private final WorkspaceRepository workspaceRepository;

    @Override
    public void addWorkspace(Workspace workspace) {
        workspaceRepository.save(workspace);

    }

    @Override
    public void updateWorkspace(Workspace workspace) {
        workspaceRepository.save(workspace);

    }

    @Override
    public void deleteWorkspace(Long id) {
        workspaceRepository.deleteById(id);

    }

    @Override
    public List<Workspace> findAllWorkspaces() {
        return workspaceRepository.findAll();
    }

    @Override
    public List<Workspace> findByStatus(WorkspaceStatus status) {
        return workspaceRepository.findByStatus(status);
    }

    @Override
    public List<Workspace> findByType(WorkspaceType type) {
        return workspaceRepository.findByType(type);
    }
}
