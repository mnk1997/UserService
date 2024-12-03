package com.assignment.userservice.controller;

import com.assignment.userservice.exceptions.RoleAlreadyExist;
import com.assignment.userservice.models.Role;
import com.assignment.userservice.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/role")
public class RolesController {
    private final RoleService roleService;
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody String role) throws RoleAlreadyExist {
        Role roleEntity=roleService.saveNewRole(role);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roleEntity.getValue());

    }
}
