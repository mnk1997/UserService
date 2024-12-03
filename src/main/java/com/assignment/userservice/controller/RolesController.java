package com.assignment.userservice.controller;

import com.assignment.userservice.exceptions.RoleAlreadyExist;
import com.assignment.userservice.models.Role;
import com.assignment.userservice.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class RolesController {
    private final RoleService roleService;
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }
    public ResponseEntity<String> createRole(String role) throws RoleAlreadyExist {
        Role roleEntity=roleService.saveNewRole(role);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleEntity.getValue());

    }
}
