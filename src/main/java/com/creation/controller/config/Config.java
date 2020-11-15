package com.creation.controller.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Gson getGson() {
        return new Gson();
    }
  /*  @Bean
    @Lazy
    public UserException userException(){
        return new UserException(null);
    }*/
}
