package com.workspacesharing.service;

import com.workspacesharing.enums.WorkspaceStatus;
import com.workspacesharing.enums.WorkspaceType;
import com.workspacesharing.model.Booking;
import com.workspacesharing.model.User;
import com.workspacesharing.model.Workspace;

import java.util.List;

public interface IWorkspaceService {
    void addWorkspace(Workspace workspace);

    void updateWorkspace(Workspace workspace);

    void deleteWorkspace(Long id);

    List<Workspace> findAllWorkspaces();

    List<Workspace> findByStatus(WorkspaceStatus status);

    List<Workspace> findByType(WorkspaceType type);

}
