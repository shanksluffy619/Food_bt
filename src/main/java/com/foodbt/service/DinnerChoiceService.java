package com.foodbt.service;

import com.foodbt.payload.DinnerChoiceDto;

public interface DinnerChoiceService {
    DinnerChoiceDto creatDinnerChoiceForUser(long userId, DinnerChoiceDto dinnerChoiceDto);
}
