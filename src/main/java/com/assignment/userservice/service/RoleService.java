package com.assignment.userservice.service;

import com.assignment.userservice.exceptions.RoleNotFoundException;
import com.assignment.userservice.models.Role;
import com.assignment.userservice.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    private RoleRepository roleRepository;

    @Override
    public Optional<String> validateRole(String role) throws RoleNotFoundException {
        if(roleRepository.findByValue(role).isEmpty())
            throw new RoleNotFoundException(role);
        else
            return Optional.of(role);

    }

    @Override
    public Role saveNewRole(Role role) throws RoleNotFoundException {
        return roleRepository.save(role);

    }
}
