package com.foodbt.entity;

import com.foodbt.utils.Gender;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_gender_age")
public class GenderAge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private int age;


}
