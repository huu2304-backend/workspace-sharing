package com.workspacesharing.controller;

import com.workspacesharing.enums.WorkspaceStatus;
import com.workspacesharing.enums.WorkspaceType;
import com.workspacesharing.model.Workspace;
import com.workspacesharing.service.IBookingService;
import com.workspacesharing.service.IWorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/workspaces")
public class WorkspaceController {
    private final IWorkspaceService iWorkspaceService;
    @GetMapping("/add")
    public String showAddWorkspace(Model model) {
        model.addAttribute("workspace", new Workspace());
        model.addAttribute("statuses", WorkspaceStatus.values());
        model.addAttribute("types", WorkspaceType.values());
        return "/workspaces/add";
    }

    @PostMapping("/add")
    public String addWorkspace(@ModelAttribute Workspace workspace) {
        iWorkspaceService.addWorkspace(workspace);
        return "redirect:/workspaces/list";
    }
    @GetMapping("/list")
    public String listWorkspace(Model model) {
        model.addAttribute("workspaces", iWorkspaceService.findAllWorkspaces());
        return "/workspaces/list";
    }
}
