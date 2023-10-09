package com.foodbt.entity;

import com.foodbt.utils.FoodAllergyStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "food_allergies")
public class FoodAllergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FoodAllergyStatus status;

    @Column(length = 255)
    private String specification;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}