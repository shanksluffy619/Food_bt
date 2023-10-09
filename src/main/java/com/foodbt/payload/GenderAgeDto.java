package com.foodbt.payload;

import com.foodbt.utils.Gender;
import lombok.Data;

@Data
public class GenderAgeDto {
    private Long userId;
    private Gender gender;
    private int age;
}

