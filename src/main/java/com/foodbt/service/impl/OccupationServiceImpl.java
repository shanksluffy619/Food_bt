package com.foodbt.service.impl;

import com.foodbt.entity.OccupationEntity;
import com.foodbt.entity.User;
import com.foodbt.exception.ResourceNotFoundException;
import com.foodbt.payload.OccupationDto;
import com.foodbt.repository.OccupationRepository;
import com.foodbt.repository.UserRepository;
import com.foodbt.service.OccupationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepository userRepository;
    private final OccupationRepository occupationRepository;

    @Autowired
    public OccupationServiceImpl(OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    @Override
    public OccupationDto createOccupation(OccupationDto occupationDTO, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );



        OccupationEntity occupationEntity = convertToEntity(occupationDTO);
        occupationEntity.setUser(user);
        OccupationEntity savedOccupationEntity = occupationRepository.save(occupationEntity);
        savedOccupationEntity.setUser(user);
        return convertToDTO(savedOccupationEntity);
    }

    private OccupationDto convertToDTO(OccupationEntity savedOccupationEntity) {
        OccupationDto map = mapper.map(savedOccupationEntity, OccupationDto.class);
        return map;
    }

    private OccupationEntity convertToEntity(OccupationDto occupationDTO) {
        OccupationEntity map = mapper.map(occupationDTO, OccupationEntity.class);
        return map;
    }
}
