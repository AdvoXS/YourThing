package com.creation.core.config;

import com.creation.restobject.Auth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

public class DataObjectConfig {

    @Bean
    @Lazy
    public Auth auth() {
        return new Auth();
    }

}
