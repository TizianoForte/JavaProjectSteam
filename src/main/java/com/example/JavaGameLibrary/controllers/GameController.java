package com.example.JavaGameLibrary.controllers;

import com.example.JavaGameLibrary.entities.Game;
import com.example.JavaGameLibrary.entities.User;
import com.example.JavaGameLibrary.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public Iterable<Game> getAllGames(@RequestParam(required = false) String titleLike) {
        Iterable<Game> games;
        if(titleLike!=null) {

        }
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getUserByID(@PathVariable long id) {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()) {
            return ResponseEntity.ok(game.get());
        }
        return ResponseEntity.notFound().build();
    }

}
