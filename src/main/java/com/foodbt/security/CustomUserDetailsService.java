package com.foodbt.security;

import com.foodbt.entity.Role;
import com.foodbt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailOrPhoneNumber) throws UsernameNotFoundException {
        com.foodbt.entity.User user = userRepository.findByEmailOrPhoneNumber(emailOrPhoneNumber, emailOrPhoneNumber).orElseThrow(
                () -> new UsernameNotFoundException("User not found with email or mobile number: " + emailOrPhoneNumber)
        );
        return new
                org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapToAuthorities(user.getRole()));
    }

        private Collection<? extends GrantedAuthority> mapToAuthorities(Set < Role> roles) {
            List<SimpleGrantedAuthority> rolee = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            return rolee;
    }
    }

