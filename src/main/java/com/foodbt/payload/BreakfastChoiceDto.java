package com.foodbt.payload;

import com.foodbt.utils.BreakfastOption;
import lombok.Data;

import java.util.List;

@Data
public class BreakfastChoiceDto {
    private Long userId;
    private List<BreakfastOption> breakfastOptions;

}

