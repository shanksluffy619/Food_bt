package com.foodbt.entity;

import com.foodbt.utils.DinnerOption;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "dinner_choices")
public class DinnerChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ElementCollection(targetClass = DinnerOption.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "dinner_options", joinColumns = @JoinColumn(name = "dinner_choice_id"))
    @Enumerated(EnumType.STRING)
    private List<DinnerOption> dinnerOptions;


}
