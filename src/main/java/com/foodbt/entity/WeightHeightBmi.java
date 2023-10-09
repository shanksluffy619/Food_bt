package com.foodbt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_weight_height_bmi")
public class WeightHeightBmi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false)
    private double currentWeight; // Current weight in kilograms

    @Column(nullable = false)
    private double currentHeight; // Current height in meters

    @Column(nullable = false)
    private double bmi; // BMI (Body Mass Index) - You can calculate and set this value as needed

    // Constructors, getters, setters, and other methods
}
