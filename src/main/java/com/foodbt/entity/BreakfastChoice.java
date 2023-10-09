package com.foodbt.entity;

import com.foodbt.utils.BreakfastOption;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "breakfast_choices")
public class BreakfastChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER) // Use FetchType.EAGER to load User eagerly
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // Assuming you have a User entity

    @ElementCollection(targetClass = BreakfastOption.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "breakfast_options", joinColumns = @JoinColumn(name = "breakfast_choice_id"))
    @Enumerated(EnumType.STRING)
    private List<BreakfastOption> breakfastOptions;

    // Constructors, getters, setters, and other methods
}
