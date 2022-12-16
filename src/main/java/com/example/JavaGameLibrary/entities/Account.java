package com.example.JavaGameLibrary.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Account {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nickname;
    private String email;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String billingAddress;
    @Check(constraints = "amount >= 0" )
    private double amount;
    @OneToOne
    private Library library;

}
