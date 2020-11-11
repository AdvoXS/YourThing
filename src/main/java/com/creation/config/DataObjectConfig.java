package com.creation.config;

import com.creation.restobject.Auth;
import com.creation.restobject.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataObjectConfig {
    @Bean
    public Auth getAuth() {
        return new Auth();
    }

    public AuthService getAuthService() {
        return new AuthService();
    }
}
