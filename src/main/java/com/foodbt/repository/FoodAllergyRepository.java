package com.foodbt.repository;

import com.foodbt.entity.FoodAllergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodAllergyRepository extends JpaRepository<FoodAllergy, Long> {
}
