package com.assignment.userservice.controller;
a
import com.assignment.userservice.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    public ResponseEntity<UserSignUpResponseDto> signUp(UserSignUpRequestDto user)
    {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<UserSignInResponseDto> signIn(UserSignInRequestDto user)
    {
        return ResponseEntity.ok(null);
    }

    public ResponseEntity<TokenValidateResponseDto> validateToken(TokenValidateRequestDto token)
    {
        return ResponseEntity.ok(null);
    }

}
