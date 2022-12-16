package com.example.JavaGameLibrary.controllers;

import com.example.JavaGameLibrary.entities.Game;
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
            games = gameRepository.findByTitleLike("%"+titleLike+"%");
        } else {
            games = gameRepository.findAll();
        }
        return games;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameByID(@PathVariable long id) {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()) {
            return ResponseEntity.ok(game.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameRepository.saveAndFlush(game);
    }

}
