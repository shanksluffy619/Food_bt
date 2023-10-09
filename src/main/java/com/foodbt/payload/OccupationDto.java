package com.foodbt.payload;

import com.foodbt.utils.Occupation;
import lombok.Data;

@Data
public class OccupationDto {
    private Long id;
    private Long userId;
    private Occupation occupation;
    private String others;
}