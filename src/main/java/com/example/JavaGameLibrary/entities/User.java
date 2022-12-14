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
public class User extends Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nickname;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String billingAddress;
    @Check(constraints = "amount >= 0" )
    private double amount;
    @OneToOne
    private Library library;

}
