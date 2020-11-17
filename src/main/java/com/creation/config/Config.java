package com.creation.config;

import com.creation.core.utils.Property;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Gson getGson() {
        return new Gson();
    }

    @Bean
    public Property properties() {
        return new Property();
    }
  /*  @Bean
    @Lazy
    public UserException userException(){
        return new UserException(null);
    }*/
}
