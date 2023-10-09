package com.foodbt.service;

import com.foodbt.entity.LunchChoice;
import com.foodbt.payload.LunchChoiceDto;

public interface LunchChoiceService {
    LunchChoiceDto createLunchChoice(Long userId, LunchChoiceDto lunchChoicedto);
}