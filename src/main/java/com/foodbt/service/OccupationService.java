package com.foodbt.service;

import com.foodbt.payload.OccupationDto;

public interface OccupationService {
    OccupationDto createOccupation(OccupationDto occupationDTO, Long userId);
}
