package com.login.loginpage.service.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(
            "/",
            "/login",
            "/error",
            "/entrar",
            "/img/**",
            "/vendor/**",
            "/js/**",
            "/favicon.ico",
            "/css/**"
        );
    }
}
