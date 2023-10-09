package com.foodbt.controller;



import com.foodbt.entity.BreakfastChoice;
import com.foodbt.payload.ApiResponse;
import com.foodbt.payload.BreakfastChoiceDto;
import com.foodbt.service.BreakfastChoiceService;
import com.foodbt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breakfast")
public class BreakfastChoiceController {
@Autowired
    private UserService userService;
    @Autowired
    private BreakfastChoiceService breakfastChoiceService;

    //localhost:8080/api/breakfast/user/1
//    {
//        "breakfastOptions": ["BIRYANI","PARATHA","MAGGI","TEA"]
//    }
    @PostMapping("/user/{userId}")
    public ResponseEntity<BreakfastChoice> createBreakfastChoiceForUser(
            @PathVariable Long userId, @RequestBody BreakfastChoiceDto breakfastChoiceDto) {
        BreakfastChoice createdChoice = breakfastChoiceService.createBreakfastChoiceForUser(userId, breakfastChoiceDto);
        return new ResponseEntity<>(createdChoice, HttpStatus.CREATED);




    }


    // localhost:8080/api/breakfast/user/1
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BreakfastChoiceDto>> getBreakfastChoicesByUserId(@PathVariable Long userId) {
        List<BreakfastChoiceDto> breakfastChoicesByUserId = breakfastChoiceService.getBreakfastChoicesByUserId(userId);
        return new ResponseEntity<>(breakfastChoicesByUserId, HttpStatus.OK);




    }

    }
