package com.example.JavaGameLibrary.controllers;

import com.example.JavaGameLibrary.entities.Account;
import com.example.JavaGameLibrary.entities.Feedback;
import com.example.JavaGameLibrary.entities.Game;
import com.example.JavaGameLibrary.entities.Purchase;
import com.example.JavaGameLibrary.repositories.AccountRepository;
import com.example.JavaGameLibrary.repositories.GameRepository;
import com.example.JavaGameLibrary.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/{gameId}/{accountId}")
    public Purchase createPurchase(@PathVariable long gameId, @PathVariable long accountId) {
        Optional<Game> game = gameRepository.findById(gameId);
        Optional<Account> account = accountRepository.findById(accountId);
        Purchase purchase = new Purchase();
        purchase.setGame(game.get());
        purchase.setAccount(account.get());
        purchase.setPrice(game.get().getPrice());
        purchase.setBuyDate(LocalDateTime.now());
        //purchase.setFeedback(new Feedback());
        return purchaseRepository.save(purchase);
    }
}
