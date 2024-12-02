package com.assignment.userservice.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserSignUpResponseDto {
    private Date createdAt;
    private String userName;
}
