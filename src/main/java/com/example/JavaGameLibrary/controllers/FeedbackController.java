package com.example.JavaGameLibrary.controllers;

import com.example.JavaGameLibrary.entities.Feedback;
import com.example.JavaGameLibrary.entities.Game;
import com.example.JavaGameLibrary.entities.Purchase;
import com.example.JavaGameLibrary.repositories.FeedbackRepository;
import com.example.JavaGameLibrary.repositories.GameRepository;
import com.example.JavaGameLibrary.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;


    @PostMapping
    public Feedback createFeedBack(@RequestBody Map<String,Object> body) {
        Feedback feedback = new Feedback();
        Purchase purchase = purchaseRepository.findById(Long.parseLong(body.get("id").toString())).get();
        int score = Integer.parseInt(body.get("score").toString());
        feedback.setScore(score);
        feedback.setPurchase(purchase);
        return feedbackRepository.saveAndFlush(feedback);
    }

}
