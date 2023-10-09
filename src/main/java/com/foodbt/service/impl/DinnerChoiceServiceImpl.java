package com.foodbt.service.impl;

import com.foodbt.entity.DinnerChoice;
import com.foodbt.entity.User;
import com.foodbt.exception.ResourceNotFoundException;
import com.foodbt.payload.DinnerChoiceDto;
import com.foodbt.repository.DinnerChoiceRepository;
import com.foodbt.repository.UserRepository;
import com.foodbt.service.DinnerChoiceService;
import com.foodbt.utils.DinnerOption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DinnerChoiceServiceImpl implements DinnerChoiceService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private DinnerChoiceRepository dinnerChoiceRepository;



    private DinnerChoiceDto MapToDto(DinnerChoice dinnerChoice) {
        DinnerChoiceDto map = mapper.map(dinnerChoice, DinnerChoiceDto.class);
        return map;
    }

    private DinnerChoice MapToEntity(DinnerChoiceDto dinnerChoiceDto) {
        DinnerChoice map = mapper.map(dinnerChoiceDto, DinnerChoice.class);
        return map;

    }

    @Override
    public DinnerChoiceDto creatDinnerChoiceForUser(long userId, DinnerChoiceDto dinnerChoiceDto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","Id",userId));

        DinnerChoice dinnerChoice = new DinnerChoice();

        dinnerChoice.setUser(user);

        List<DinnerOption> dinnerOptions = dinnerChoiceDto.getDinnerOptions();
        dinnerChoice.setDinnerOptions(dinnerOptions);
        DinnerChoice save = dinnerChoiceRepository.save(dinnerChoice);
        DinnerChoiceDto dinnerChoiceDto1 = MapToDto(save);



        return dinnerChoiceDto1;
    }
}
