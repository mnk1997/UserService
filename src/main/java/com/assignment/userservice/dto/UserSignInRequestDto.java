package com.assignment.userservice.dto;


import lombok.Data;

@Data
public class UserSignInRequestDto {
    private String userName;
    private String password;
}
