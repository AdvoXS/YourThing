package com.creation.core.config;

import com.creation.controllers.get.MainController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration init controllers beans
 * !!!The name of the beans must be the same as the name of the class!!!
 */
@Configuration
public class ControllerConfig {
    @Bean(name = "MainController")
    public MainController mainController() {
        return new MainController();
    }
}
