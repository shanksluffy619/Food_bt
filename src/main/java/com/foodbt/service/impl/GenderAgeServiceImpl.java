package com.foodbt.service.impl;

import com.foodbt.entity.GenderAge;
import com.foodbt.entity.User;
import com.foodbt.exception.ResourceNotFoundException;
import com.foodbt.payload.GenderAgeDto;
import com.foodbt.repository.GenderAgeRepository;
import com.foodbt.repository.UserRepository;
import com.foodbt.service.GenderAgeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderAgeServiceImpl implements GenderAgeService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private GenderAgeRepository genderAgeRepository;
    @Override
    public GenderAgeDto createGenderAge(Long userId, GenderAgeDto genderAgeDto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", userId)
        );

        GenderAge genderAge = MapToEntity(genderAgeDto);

        GenderAge save = genderAgeRepository.save(genderAge);

        // Set the user for the saved GenderAge
        save.setUser(user);
        genderAgeRepository.save(save);

        GenderAgeDto genderAgeDto1 = MapToDto(save);
        return genderAgeDto1;
    }

    private GenderAgeDto MapToDto(GenderAge save) {
        GenderAgeDto map = mapper.map(save, GenderAgeDto.class);
        return map;
    }

    private GenderAge MapToEntity(GenderAgeDto genderAgeDto) {
        GenderAge map = mapper.map(genderAgeDto, GenderAge.class);
        return map;
    }
}
