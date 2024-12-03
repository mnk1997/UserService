package com.assignment.userservice.service;

import com.assignment.userservice.exceptions.RoleAlreadyExist;
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
    public Role saveNewRole(String role) throws RoleNotFoundException, RoleAlreadyExist {
        //vlaidate whether the user has authority to add role or not ....


        //check if role already exists or not
        Optional<Role> roleOptional = roleRepository.findByValueEqualsIgnoreCase(role);
        if(roleOptional.isPresent())
        {
            //if exists throw error
            throw new RoleAlreadyExist("The given role already exists ");
        }
        //creating new role entity..
        Role roleEntity = new Role();
        roleEntity.setValue(role);
        return roleRepository.save(roleEntity);

    }
}
