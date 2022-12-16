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
    @Check(constraints = "price >= 0" )
    private double price;
    private LocalDate buyDate;
    @ManyToOne
    private Game game;
    @ManyToOne
    private Account account;
    @OneToOne
    private Feedback feedback;
}
