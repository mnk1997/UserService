package com.assignment.userservice.service;

import com.assignment.userservice.models.User;

public interface IUserService {
    public User signUp(User user);
    public User login(String email, String password);
     boolean validateToken(String token , String user);
}
