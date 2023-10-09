package com.foodbt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private GenderAge genderAge;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private WeightHeightBmi weightHeightBmi;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private OccupationEntity occupationEntity;
@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private FoodAllergy foodAllergy;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private MedicalConditionEntity medicalConditionEntity;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore // Add this annotation to break the infinite loop
    private List<BreakfastChoice> breakfastChoices;




    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<LunchChoice> lunchChoices;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<DinnerChoice> dinnerChoices;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Role> role = new HashSet<>();







}
