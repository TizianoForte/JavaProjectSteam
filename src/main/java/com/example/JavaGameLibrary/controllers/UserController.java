package com.example.JavaGameLibrary.controllers;

import com.example.JavaGameLibrary.entities.User;
import com.example.JavaGameLibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public User createUser(User u) {
        return userRepository.save(u);
    }

    @GetMapping("/user") // quando l'url termina con /books allora esegui questo metodo
    public String showBooks(Model m) { // il model serve per collegare il controller alla view
        //Iterable<Book> bs = br.findAll();
        //m.addAttribute("BOOKS", bs);
        return "index.html";
    }

}
