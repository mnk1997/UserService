package com.assignment.userservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserSignInResponseDto {

    private String token;
    private List<String> roles;
}
