package com.foodbt.service;

import com.foodbt.payload.GenderAgeDto;

public interface GenderAgeService {
    GenderAgeDto createGenderAge(Long userId, GenderAgeDto genderAgeDto);
}
