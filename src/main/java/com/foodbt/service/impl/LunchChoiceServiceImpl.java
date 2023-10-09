package com.foodbt.service.impl;

import com.foodbt.entity.LunchChoice;
import com.foodbt.entity.User;
import com.foodbt.exception.ResourceNotFoundException;
import com.foodbt.payload.LunchChoiceDto;
import com.foodbt.repository.LunchChoiceRepository;
import com.foodbt.repository.UserRepository;
import com.foodbt.service.LunchChoiceService;
import com.foodbt.utils.LunchOption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LunchChoiceServiceImpl implements LunchChoiceService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LunchChoiceRepository lunchChoiceRepository;
@Autowired
    ModelMapper mapper;


    @Override
    public LunchChoiceDto createLunchChoice(Long userId, LunchChoiceDto lunchChoiceDto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", userId)
        );
         LunchChoice lunchChoice = new LunchChoice();
        lunchChoice.setUser(user);
        List<LunchOption> lunchOptions = lunchChoiceDto.getLunchOptions();
        lunchChoice.setLunchOptions(lunchOptions);
        LunchChoice save = lunchChoiceRepository.save(lunchChoice);

        LunchChoiceDto lunchChoiceDto1 = MapToDto(save);
        return lunchChoiceDto1;


    }



    public LunchChoiceDto MapToDto(LunchChoice save) {
        LunchChoiceDto map = mapper.map(save, LunchChoiceDto.class);
        return map;
    }

    private LunchChoice MapTOEntity(LunchChoiceDto lunchChoicedto) {

        LunchChoice map = mapper.map(lunchChoicedto, LunchChoice.class);
        return map;
    }
}
