package com.foodbt.payload;

import lombok.Data;

@Data
public class WeightHeightBmiDto {
    private Long userId;
    private double currentWeight;
    private double currentHeight;
    private double bmi;
}
