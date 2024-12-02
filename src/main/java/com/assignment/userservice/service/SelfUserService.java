package com.assignment.userservice.service;

import com.assignment.userservice.models.User;
import org.springframework.stereotype.Service;


@Service
public class SelfUserService implements  IUserService{
    @Override
    public User signUp(User user) {
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public boolean validateToken(String token, String user) {
        return false;
    }
}
