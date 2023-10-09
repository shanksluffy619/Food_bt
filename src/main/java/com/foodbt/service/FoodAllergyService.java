package com.foodbt.service;



import com.foodbt.entity.User;
import com.foodbt.payload.FoodAllergyDto;

import java.util.List;

public interface FoodAllergyService {
    FoodAllergyDto createFoodAllergy(FoodAllergyDto foodAllergyDto , Long userId);

    List<FoodAllergyDto> getFoodAllergiesByUserId(Long userId);
}
