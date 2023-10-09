package com.foodbt.controller;

import com.foodbt.entity.Role;
import com.foodbt.entity.User;
import com.foodbt.payload.SignupDto;
import com.foodbt.repository.RoleRepository;
import com.foodbt.repository.UserRepository;

import com.foodbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/api/foodbt")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private  RoleRepository roleRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupDto signupDto, BindingResult result) {

        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        } else {
            if (userRepository.existsByPhoneNumber(signupDto.getPhoneNumber())) {
                return new ResponseEntity<>("User with this phone number already exists", HttpStatus.BAD_REQUEST);
            }


            if (userRepository.existsByEmail(signupDto.getEmail())) {
                return new ResponseEntity<>("User with this email already exists", HttpStatus.BAD_REQUEST);
            }


            User user = new User();
            user.setEmail(signupDto.getEmail());
            user.setPassword(encoder.encode(signupDto.getPassword()));
            user.setPhoneNumber(signupDto.getPhoneNumber());
            Role role = roleRepository.findByName("ROLE_USER").get();
            user.setRole(Collections.singleton(role));
            userRepository.save(user);






            return new ResponseEntity<>("User signed up successfully", HttpStatus.CREATED);
        }

    }
}
