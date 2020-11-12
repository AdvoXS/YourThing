package com.creation.controller.spring;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@Controller
public class SController {
    protected WebClient webClient = WebClient.builder()
            .baseUrl("http://api.mskpropusk.com")
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(Collections.singletonMap("url", "http://api.mskpropusk.com"))
            .build();

}
