package com.example.JavaGameLibrary.configurations;

import com.example.JavaGameLibrary.interceptors.AccountInterceptor;
import com.example.JavaGameLibrary.interceptors.PurchaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Autowired
    private AccountInterceptor accountInterceptor;
    @Autowired
    private PurchaseInterceptor purchaseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accountInterceptor);
        registry.addInterceptor(purchaseInterceptor);
    }
}
