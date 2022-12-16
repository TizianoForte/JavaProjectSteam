package com.example.JavaGameLibrary.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.time.LocalDateTime;


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
    private LocalDateTime buyDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private Game game;
    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;
    @OneToOne
    private Feedback feedback;
}
