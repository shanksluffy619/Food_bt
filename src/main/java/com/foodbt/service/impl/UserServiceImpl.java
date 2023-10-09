package com.foodbt.service.impl;

import com.foodbt.entity.User;
import com.foodbt.payload.SignupDto;
import com.foodbt.repository.UserRepository;
import com.foodbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    private UserRepository userRepository;
    @Override
    public User getUserById(Long userId) {
        Optional<User> byId = userRepository.findById(userId);

        User user = byId.get();
        return user;
    }
}
