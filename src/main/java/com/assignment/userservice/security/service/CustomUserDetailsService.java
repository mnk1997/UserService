package com.assignment.userservice.security.service;

import com.assignment.userservice.models.User;
import com.assignment.userservice.security.repository.SpringSecurityUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private  SpringSecurityUserRepository springSecurityUserRepository;

    public CustomUserDetailsService(SpringSecurityUserRepository springSecurityUserRepository) {
        this.springSecurityUserRepository = springSecurityUserRepository;
    }
    SpringSecurityUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  springSecurityUserRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

    }
}
