package com.foodbt.payload;

import com.foodbt.utils.MedicalCondition;
import lombok.Data;

@Data
public class MedicalConditionDto {
    private Long userId;
    private MedicalCondition medicalCondition;
}