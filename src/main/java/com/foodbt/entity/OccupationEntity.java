package com.foodbt.entity;

import com.foodbt.utils.Occupation;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_occupation")
public class OccupationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
        private Occupation occupation;
    @Column
    private String others; /


    @PrePersist
    @PreUpdate
    private void checkNullableConstraint() {
        if (occupation != null && occupation != Occupation.OTHER) {
            others = null;


        }
    }
}
