package com.foodbt.controller;

import com.foodbt.payload.FoodAllergyDto;
import com.foodbt.service.FoodAllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodallergies")
public class FoodAllergyController {
    @Autowired
    private FoodAllergyService foodAllergyService;

    // Create a new Food Allergy
    @PostMapping("/user/{userId}")
    public ResponseEntity<FoodAllergyDto> createFoodAllergy(@PathVariable Long userId ,@RequestBody FoodAllergyDto foodAllergyDto) {
        FoodAllergyDto createdFoodAllergy = foodAllergyService.createFoodAllergy(foodAllergyDto, userId);
        return new ResponseEntity<>(createdFoodAllergy, HttpStatus.CREATED);
    }

    // Get Food Allergies by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FoodAllergyDto>> getFoodAllergiesByUserId(@PathVariable Long userId) {
        List<FoodAllergyDto> foodAllergies = foodAllergyService.getFoodAllergiesByUserId(userId);
        return new ResponseEntity<>(foodAllergies, HttpStatus.OK);
    }
}
