    package com.foodbt.payload;

    import com.foodbt.utils.DinnerOption;
    import lombok.Data;

    import java.util.List;

    @Data
    public class DinnerChoiceDto {
        private Long userId;
        private List<DinnerOption> dinnerOptions;
    }
