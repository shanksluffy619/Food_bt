package com.foodbt.payload;

import com.foodbt.utils.FoodAllergyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodAllergyDto {
    private Long id;
    private FoodAllergyStatus status;
    private String specification;
}