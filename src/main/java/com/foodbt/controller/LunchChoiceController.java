package com.foodbt.controller;

import com.foodbt.payload.LunchChoiceDto;
import com.foodbt.service.LunchChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lunch-choices")
public class LunchChoiceController {
    @Autowired
    private LunchChoiceService lunchChoiceService;

    @RestController
    @RequestMapping("/api/lunch")
    public class LunchChoicesController {
        @Autowired
        private LunchChoiceService lunchChoiceService;

        @PostMapping("/user/{userId}")
        public ResponseEntity<?> createLunchChoice(@PathVariable Long userId, @RequestBody LunchChoiceDto lunchChoicedto) {
            LunchChoiceDto lunchChoice = lunchChoiceService.createLunchChoice(userId, lunchChoicedto);
            ResponseEntity response = new ResponseEntity<>(lunchChoice,HttpStatus.CREATED);
            return response;

        }
    }
}





