package com.assignment.userservice.utils;

import com.assignment.userservice.exceptions.IncorrectPhoneNumber;
import com.assignment.userservice.exceptions.NoRoleSelected;
import com.assignment.userservice.exceptions.RoleNotFoundException;
import com.assignment.userservice.models.Role;
import com.assignment.userservice.repository.RoleRepository;
import com.assignment.userservice.service.IRoleService;
import com.assignment.userservice.service.RoleService;

import java.util.List;

public class UserValidation {

    private IRoleService roleService;
    public UserValidation() {
        IRoleService roleService = new RoleService();
    }
    public  boolean isPhoneNumberValid(String phoneNumber)  throws IncorrectPhoneNumber {
        if(phoneNumber == null || phoneNumber.length() != 10) {
            throw new IncorrectPhoneNumber("Phone number should be 10 digits");
        }
        return true;

    }
    public  boolean isRolesValid(List<Role> roles) {
        if(roles == null || roles.isEmpty()) {
            throw new NoRoleSelected("Please select atleast one roles ");
        }
        int count =0;
        StringBuilder rolesNotValid = new StringBuilder("Roles not valid");
        for(Role role : roles) {
            try
            {
                roleService.validateRole(role.getValue());
            }catch(RoleNotFoundException err)
            {count +=1;
                rolesNotValid.append(err.getMessage());

            }

        }
        if(count>0)
        {
            throw new RoleNotFoundException(rolesNotValid.toString());
        }
        else
            return true;

    }
}
