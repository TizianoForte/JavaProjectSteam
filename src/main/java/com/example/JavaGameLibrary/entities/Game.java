package com.example.JavaGameLibrary.entities;

import com.example.JavaGameLibrary.enums.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Game {
    @Id
    @JsonProperty("id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @Check(constraints = "price >= 0" )
    private double price;
    private Genre genre;

}
