package com.foodbt.repository;

import com.foodbt.entity.OccupationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<OccupationEntity, Long> {
    // Define any custom query methods if needed
}