package com.creation.config;

import com.creation.controller.get.MainController;
import com.creation.controller.post.OperatorLoginC;
import com.creation.controller.post.UserSignUpC;
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

    @Bean(name = "OperatorLoginC")
    public OperatorLoginC operatorLoginC() {
        return new OperatorLoginC();
    }

    @Bean(name = "UserSignUpC")
    public UserSignUpC userSingC() {
        return new UserSignUpC();
    }
}
