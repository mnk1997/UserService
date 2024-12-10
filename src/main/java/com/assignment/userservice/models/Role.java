package com.assignment.userservice.models;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;


@Data
@Entity
public class Role  extends BaseModel  implements GrantedAuthority {
    private String value;

    @Override
    public String getAuthority() {
        return this.value;
    }
}