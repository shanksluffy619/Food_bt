package com.foodbt.repository;

import com.foodbt.entity.GenderAge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderAgeRepository extends JpaRepository<GenderAge,Long> {
}
