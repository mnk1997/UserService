package com.assignment.userservice.controller;
import com.assignment.userservice.dto.*;
import com.assignment.userservice.exceptions.*;
import com.assignment.userservice.models.Session;
import com.assignment.userservice.models.User;
import com.assignment.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
    private static String authorizationRequestBaseUri = "/o/oauth2//v2/auth";

    private IUserService  userService;
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserSignUpResponseDto> signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) throws IncorrectPhoneNumber {
        User user=userService.signUp(UserSignUpRequestDto.toUser(userSignUpRequestDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserSignUpResponseDto.fromUser(user));

    }
    @GetMapping("/login")
    public String signIn(Model model)
    {
        Iterable<ClientRegistration> clientRegistrations = null;
        ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
                .as(Iterable.class);
        if (type != ResolvableType.NONE &&
                ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
            clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
        }
        clientRegistrations.forEach(ele-> System.out.println(ele.getClientName()+":"+
                        authorizationRequestBaseUri + "/" + ele.getRegistrationId()
                ));
        clientRegistrations.forEach(registration ->
                oauth2AuthenticationUrls.put(registration.getClientName(),
                        authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
        model.addAttribute("urls", oauth2AuthenticationUrls);
        return "custom";
    }

    @PostMapping("/login")
    public ResponseEntity<UserSignInResponseDto> signIn(@RequestBody UserSignInRequestDto user) throws UserNotFoundException, PasswordAndUserNameNotMatchedException {
        System.out.println("Caleed the signIn method");
        Session token=userService.login(user.getUserName(),user.getPassword());
        return ResponseEntity.status(HttpStatus.OK)
                .body(UserSignInResponseDto.fromSession(token));
    }

    @PostMapping("/validateToken")
    public ResponseEntity<TokenValidateResponseDto> validateToken(@RequestBody TokenValidateRequestDto token) throws UserNotFoundException, NoValidTokenFoundException, SessionExpiredException {
        Session session =userService.validateToken(token.getToken(),token.getUserName());
        return ResponseEntity.status(HttpStatus.OK)
                .body(TokenValidateResponseDto.fromToken(session));
    }

    @GetMapping("/auth-success")
     public String userSuccessAfterOAuth2Login(@RequestParam Map<String,String> requestParams)
    {

        System.out.println("called");
        if (requestParams!=null)
        {
            System.out.println("size "+requestParams.size());
        }
       for(String key:requestParams.keySet())
       {
           System.out.println(key+":"+requestParams.get(key));
       }


       // System.out.println("user success with auth principal  "+authentication.getPrincipal());
       // System.out.println("token "+authentication.getName());
        return "home";
    }

}
