package com.foodbt.entity;

import com.foodbt.utils.MedicalCondition;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_medical_condition")
public class MedicalConditionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MedicalCondition medicalCondition;


}

