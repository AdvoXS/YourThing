package com.creation.controller.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Component
public class SController {
    @Bean
    public WebClient getClient() {
        return WebClient.builder()
                .baseUrl("http://api.mskpropusk.com")
                .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultUriVariables(Collections.singletonMap("url", "http://api.mskpropusk.com"))
                .build();
    }

}
