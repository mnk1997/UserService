package com.assignment.userservice.models;


import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date createdAt;
}
