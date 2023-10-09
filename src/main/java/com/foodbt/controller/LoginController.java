package com.foodbt.controller;

import com.foodbt.payload.LoginDto;
import com.foodbt.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
@RequestMapping("/api/foodbt")
public class LoginController {
@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;



@PostMapping("/Login")
public ResponseEntity<?>authenticateUser(@RequestBody LoginDto dto){

    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmailOrPhoneNumber(), dto.getPassword()));


    SecurityContextHolder.getContext().setAuthentication(authenticate);
    ResponseEntity response = new ResponseEntity("user logged in successfully", HttpStatus.OK);
    return response;

}
}
