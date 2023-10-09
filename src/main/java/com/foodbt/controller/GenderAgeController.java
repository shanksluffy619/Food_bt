package com.foodbt.controller;

import com.foodbt.payload.GenderAgeDto;
import com.foodbt.service.GenderAgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/GenderAge")
public class GenderAgeController {
    @Autowired
    private GenderAgeService genderAgeService;

//    localhost:8080/api/GenderAge/user/1
//    {
//
//        "gender": "MALE",
//            "age": 30
//    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<?>createAgeAndGender(@PathVariable Long userId, @RequestBody GenderAgeDto genderAgeDto){
        GenderAgeDto genderAge = genderAgeService.createGenderAge(userId, genderAgeDto);
        ResponseEntity response = new ResponseEntity<>(genderAge, HttpStatus.CREATED);
        return response;


    }

//    {
//        "userId":"1",
//            "gender": "MALE",
//            "age": 30
//    }

}
