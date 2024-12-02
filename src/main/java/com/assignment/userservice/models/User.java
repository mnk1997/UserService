package com.assignment.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "user_table")
public class User extends BaseModel {
    private String email;
    private String password;
    private String firstName;
    private String phoneNumber;
    @ManyToMany
    private List<Role> roles;

}
