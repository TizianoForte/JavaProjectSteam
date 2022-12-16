package com.example.JavaGameLibrary.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Check(constraints = "score >= 1 and score <= 5" )
    private int score;
    @OneToOne
    @NotNull
    private Purchase purchase;
}
