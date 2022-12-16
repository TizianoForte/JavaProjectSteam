package com.example.JavaGameLibrary.controllers;

import com.example.JavaGameLibrary.entities.Game;
import com.example.JavaGameLibrary.entities.Library;
import com.example.JavaGameLibrary.repositories.GameRepository;
import com.example.JavaGameLibrary.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private LibraryRepository libraryRepository;

    @GetMapping("/{id}")
    public Iterable<String> getAllGamesByUserId(@PathVariable("id") long id) {
        return libraryRepository.getAllGamesByUserId(id);
    }

    @DeleteMapping("/{idGame}/{idAccount}")
    public void deleteGame(@PathVariable("idGame") long idGame,@PathVariable("idAccount") long idAccount) {
        libraryRepository.deleteGameFromLibrary(idGame,idAccount);
    }


}
