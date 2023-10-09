package com.foodbt.service;

import com.foodbt.entity.BreakfastChoice;
import com.foodbt.entity.User;
import com.foodbt.payload.BreakfastChoiceDto;
import com.foodbt.payload.SignupDto;

public interface UserService {

    User getUserById(Long userId);

}
