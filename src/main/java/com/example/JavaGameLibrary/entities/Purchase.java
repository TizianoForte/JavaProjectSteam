package com.example.JavaGameLibrary.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Check(constraints = "pricePayed >= 0" )
    private double pricePayed;
    private LocalDate buyDate;
    @OneToOne
    private Game game;
    @OneToOne
    private User user;
    @OneToOne
    private Feedback feedback;
}
