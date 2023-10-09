package com.foodbt.service.impl;

import com.foodbt.entity.BreakfastChoice;

import com.foodbt.entity.User;
import com.foodbt.exception.ResourceNotFoundException;
import com.foodbt.payload.BreakfastChoiceDto;
import com.foodbt.repository.BreakfastChoiceRepository;
import com.foodbt.repository.UserRepository;
import com.foodbt.service.BreakfastChoiceService;
import com.foodbt.utils.BreakfastOption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BreakfastChoiceServiceImpl implements BreakfastChoiceService {

    @Autowired
    private BreakfastChoiceRepository breakfastChoiceRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<BreakfastChoiceDto> getBreakfastChoicesByUserId(Long userId) {

        List<BreakfastChoice> byUserId = breakfastChoiceRepository.findByUserId(userId);
        if (byUserId.isEmpty()){
            throw new ResourceNotFoundException("User","Id",userId);
        }else {
            List<BreakfastChoiceDto> collect = byUserId.stream().map(choice -> MapToDto(choice)).collect(Collectors.toList());
            return collect;
        }

    }

    private BreakfastChoiceDto MapToDto(BreakfastChoice choice) {
        BreakfastChoiceDto map = mapper.map(choice, BreakfastChoiceDto.class);
        return map;
    }

    @Override
    public BreakfastChoice createBreakfastChoiceForUser(Long userId, BreakfastChoiceDto breakfastChoiceDto) {

        BreakfastChoice breakfastChoice = new BreakfastChoice();


        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));

        breakfastChoice.setUser(user);


        List<BreakfastOption> breakfastOptions = breakfastChoiceDto.getBreakfastOptions();
        breakfastChoice.setBreakfastOptions(breakfastOptions);


        return breakfastChoiceRepository.save(breakfastChoice);

    }

}