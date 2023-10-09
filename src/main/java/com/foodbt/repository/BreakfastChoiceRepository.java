package com.foodbt.repository;

import com.foodbt.entity.BreakfastChoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BreakfastChoiceRepository extends JpaRepository<BreakfastChoice, Long> {
    List<BreakfastChoice> findByUserId(Long userId);
}
