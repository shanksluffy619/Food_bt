package com.foodbt.payload;

import com.foodbt.utils.LunchOption;
import lombok.Data;

import java.util.List;

@Data
public class LunchChoiceDto {
    private Long userId;
    private List<LunchOption> lunchOptions;
}
