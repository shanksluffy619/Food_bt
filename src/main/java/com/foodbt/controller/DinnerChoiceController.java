package com.foodbt.controller;

import com.foodbt.payload.DinnerChoiceDto;
import com.foodbt.service.DinnerChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dinner")
public class DinnerChoiceController {
    @Autowired
    private DinnerChoiceService dinnerChoiceService;



    // localhost:8080/api/dinner/user/1

    //        {
//            "dinnerOptions":["CHAPATI","CHICKEN"]
//        }
    @PostMapping("/user/{userId}")
    public ResponseEntity<?> DinnerChoiceForUser(@PathVariable long userId, @RequestBody DinnerChoiceDto dinnerChoiceDto){
        DinnerChoiceDto dinnerChoiceDto1 = dinnerChoiceService.creatDinnerChoiceForUser(userId, dinnerChoiceDto);
        ResponseEntity response = new ResponseEntity<>(dinnerChoiceDto1, HttpStatus.CREATED);

        return response;



    }

}
