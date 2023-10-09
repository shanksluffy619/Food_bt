package com.foodbt.controller;

import com.foodbt.payload.OccupationDto;
import com.foodbt.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/occupation")
public class OccupationController {

    private final OccupationService occupationService;

    @Autowired
    public OccupationController(OccupationService occupationService) {
        this.occupationService = occupationService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<OccupationDto> createOccupation(@PathVariable Long userId, @RequestBody OccupationDto occupationDTO) {
        OccupationDto savedOccupationDTO = occupationService.createOccupation(occupationDTO,userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOccupationDTO);
    }

    // Other controller methods (get, update, delete) go here
}