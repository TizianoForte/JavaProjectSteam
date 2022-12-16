package com.example.JavaGameLibrary.interceptors;

import com.example.JavaGameLibrary.entities.Account;
import com.example.JavaGameLibrary.repositories.AccountRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Component
public class AccountInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
        Date data = new Date(System.currentTimeMillis());
        System.out.println(format.format(data));
         */
        System.out.println(request.getRequestURL());
        StringBuffer url = request.getRequestURL();
        String urlString = url.toString();
        if(!urlString.contains("account")) {
            return true;
        }
        String id = urlString.substring(urlString.lastIndexOf("/")+1);
        System.out.println(id);
        Optional<Account> user = accountRepository.findById(Long.parseLong(id));
        if(user.isPresent()) {
            return true;
        } else {
            response.setStatus(404);
            throw new Exception("Utente non trovato!");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
