package com.example.JavaGameLibrary.interceptors;

import com.example.JavaGameLibrary.entities.Account;
import com.example.JavaGameLibrary.repositories.AccountRepository;
import com.example.JavaGameLibrary.repositories.GameRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Component
public class PurchaseInterceptor implements HandlerInterceptor {
    private final AccountRepository accountRepository;
    private final GameRepository gameRepository;

    public PurchaseInterceptor(AccountRepository accountRepository,
                               GameRepository gameRepository) {
        this.accountRepository = accountRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL());
        StringBuffer url = request.getRequestURL();
        String urlString = url.toString();
        if(!urlString.contains("purchase")) {
            return true;
        }
        long accountId = Long.parseLong(urlString.substring(urlString.lastIndexOf("/")+1));
        System.out.println(accountId);
        urlString = urlString.substring(0,urlString.lastIndexOf("/"));
        System.out.println(urlString);
        long gameId = Long.parseLong(urlString.substring(urlString.lastIndexOf("/")+1));
        System.out.println(gameId);

        if(accountRepository.findById(accountId).get().getAmount()>=gameRepository.findById(gameId).get().getPrice()) {
            return true;
        } else {
            //response.setStatus(404);
            throw new Exception("PORACCIO!!!!");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(request.getRequestURL());
        StringBuffer url = request.getRequestURL();
        String urlString = url.toString();
        long accountId = Long.parseLong(urlString.substring(urlString.lastIndexOf("/")+1));
        urlString = urlString.substring(0,urlString.lastIndexOf("/"));
        System.out.println(urlString);
        long gameId = Long.parseLong(urlString.substring(urlString.lastIndexOf("/")+1));
        Account account = accountRepository.findById(accountId).get();
        account.setAmount(account.getAmount()-gameRepository.findById(gameId).get().getPrice());
        if(account.getAmount()<0) {
            throw new Exception("Il saldo risulta negativo!!!");
        }
    }
}
