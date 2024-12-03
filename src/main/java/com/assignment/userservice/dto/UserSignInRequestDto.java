package com.assignment.userservice.dto;


import com.assignment.userservice.models.Role;
import com.assignment.userservice.models.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserSignInRequestDto {
    private String userName;
    private String password;
    private PasswordEncoder passwordEncoder;

    public UserSignInRequestDto(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



    public User toUser(UserSignUpRequestDto signInDto)
    {
        User user = new User();
        user.setEmail(signInDto.getEmail());
        user.setPassword(passwordEncoder.encode(signInDto.getPassword()));
        user.setFirstName(signInDto.getFirstName());
        user.setPhoneNumber(signInDto.getPhoneNumber());
        List<Role> roles = new ArrayList<>();
        for(String role : signInDto.getRoles())
        {
            Role r=new Role();
            r.setValue(role);
           roles.add(r);
        }
        user.setRoles(roles);
        return user;
    }

}
