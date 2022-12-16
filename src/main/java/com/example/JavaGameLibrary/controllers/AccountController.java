package com.example.JavaGameLibrary.controllers;

import com.example.JavaGameLibrary.entities.Account;
import com.example.JavaGameLibrary.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public Iterable<Account> getAllUsers() {
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public Account getUserByID(@PathVariable long id) {
        if(accountRepository.existsById(id)) {
            return accountRepository.getById(id);
        }
        return new Account();
    }

    @PostMapping
    public Account createUser(Account u) {
        return accountRepository.saveAndFlush(u);
    }

}
