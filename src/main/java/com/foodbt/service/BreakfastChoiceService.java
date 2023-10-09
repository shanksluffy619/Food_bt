package com.foodbt.service;

import com.foodbt.entity.BreakfastChoice;
import com.foodbt.payload.BreakfastChoiceDto;

import java.util.List;

public interface BreakfastChoiceService {
    List<BreakfastChoiceDto> getBreakfastChoicesByUserId(Long userId);

    BreakfastChoice createBreakfastChoiceForUser(Long userId, BreakfastChoiceDto breakfastChoiceDto);




}
