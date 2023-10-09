package com.foodbt.service.impl;

import com.foodbt.entity.FoodAllergy;
import com.foodbt.entity.User;
import com.foodbt.exception.ResourceNotFoundException;
import com.foodbt.payload.FoodAllergyDto;
import com.foodbt.repository.FoodAllergyRepository;
import com.foodbt.repository.UserRepository;
import com.foodbt.service.FoodAllergyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodAllergyServiceImpl implements FoodAllergyService {
    private final FoodAllergyRepository foodAllergyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public FoodAllergyServiceImpl(FoodAllergyRepository foodAllergyRepository, ModelMapper modelMapper) {
        this.foodAllergyRepository = foodAllergyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FoodAllergyDto createFoodAllergy(FoodAllergyDto foodAllergyDto , Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        FoodAllergy foodAllergy = MapTOEntity(foodAllergyDto);

        FoodAllergy save = foodAllergyRepository.save(foodAllergy);

        user.setFoodAllergy(save);
        FoodAllergyDto foodAllergyDto1 = MapTODto(save);
        return foodAllergyDto1;


    }

    private FoodAllergyDto MapTODto(FoodAllergy save) {
        FoodAllergyDto map = modelMapper.map(save, FoodAllergyDto.class);
        return map;

    }

    private FoodAllergy MapTOEntity(FoodAllergyDto foodAllergyDto) {

        FoodAllergy map = modelMapper.map(foodAllergyDto, FoodAllergy.class);
        return map;

    }

    @Override
    public List<FoodAllergyDto> getFoodAllergiesByUserId(Long userId) {
        List<FoodAllergy> foodAllergies = foodAllergyRepository.findAll();
        return foodAllergies.stream()
                .map(foodAllergy -> modelMapper.map(foodAllergy, FoodAllergyDto.class))
                .collect(Collectors.toList());
    }
}