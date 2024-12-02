package com.assignment.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSignUpRequestDto {

    private String email;
    private String password;
    private String phoneNumber;
    private List<String> roles;
    private String firstName;
}
