package com.example.JavaGameLibrary.entities;

import com.example.JavaGameLibrary.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Game {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @Check(constraints = "price >= 0" )
    private double price;
    private Genre genre;

}
