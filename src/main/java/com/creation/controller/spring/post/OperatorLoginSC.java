package com.creation.controller.spring.post;

import com.creation.controller.spring.SController;
import com.creation.restobject.Auth;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class OperatorLoginSC extends SController {
    @Autowired
    WebClient webClient;

    @Bean
    @Lazy
    public Auth getAuth() {
        Mono<String> authMono = webClient
                .method(HttpMethod.POST)
                .uri("/operators/login")
                .body(Mono.just("{\n" +
                        "    \"credentials\": {\n" +
                        "        \"email\": \"operator@test.ru\",\n" +
                        "        \"password\": \"12345678\"\n" +
                        "    }\n" +
                        "}"), String.class).retrieve().bodyToMono(String.class);
        String responseStr = authMono.block();
        return new Gson().fromJson(responseStr, Auth.class);
    }

}
