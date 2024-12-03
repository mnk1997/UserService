package com.assignment.userservice.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Entity
public class Session extends BaseModel {
    String token;
    long expiryAt;
    @ManyToOne
    User user;


}
