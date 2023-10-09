package com.foodbt.entity;

import com.foodbt.utils.LunchOption;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "lunch_choices")
public class LunchChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ElementCollection(targetClass = LunchOption.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "lunch_options", joinColumns = @JoinColumn(name = "lunch_choice_id"))
    @Enumerated(EnumType.STRING)
    private List<LunchOption> lunchOptions;

}
