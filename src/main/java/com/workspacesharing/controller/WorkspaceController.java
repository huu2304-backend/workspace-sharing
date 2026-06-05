package com.workspacesharing.controller;

import com.workspacesharing.enums.WorkspaceStatus;
import com.workspacesharing.enums.WorkspaceType;
import com.workspacesharing.model.Workspace;
import com.workspacesharing.service.IWorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
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

    @GetMapping("/edit/{id}")
    public String showEditWorkspace(@PathVariable("id") Long id, Model model) {
        Optional<Workspace> workspace = iWorkspaceService.findById(id);
        model.addAttribute("workspace", workspace.get());
        model.addAttribute("statuses", WorkspaceStatus.values());
        model.addAttribute("types", WorkspaceType.values());
        return "/workspaces/edit";
    }
    @PostMapping("/edit/{id}")
    public String editWorkspace(@PathVariable("id") Long id, @ModelAttribute Workspace workspace) {
        iWorkspaceService.updateWorkspace(workspace);
        return "redirect:/workspaces/list";
    }
    @PostMapping("/delete/{id}")
    public String deleteWorkspace(@PathVariable("id") Long id) {
        iWorkspaceService.deleteWorkspace(id);
        return "redirect:/workspaces/list";
    }
}
