package com.creation.controller.spring.login;

import com.creation.entity.Auth;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;


@Controller
@Lazy
public class OperatorLoginSC extends LoginSC {

    public Auth getAuth(String email, String pass) {
        Mono<String> authMono = webClient
                .method(HttpMethod.POST)
                .uri("/operators/login")
                .body(Mono.just("{\n" +
                        "    \"credentials\": {\n" +
                        "        \"email\": \"" + email + "\",\n" +
                        "        \"password\": \"" + pass + "\"\n" +
                        "    }\n" +
                        "}"), String.class).exchange().flatMap(clientResponse -> {
                    if (clientResponse.statusCode().isError()) {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(String.class);
                }).onErrorResume(e -> Mono.just("Error" + e.getMessage()));
        return getResult(authMono);
    }

}
