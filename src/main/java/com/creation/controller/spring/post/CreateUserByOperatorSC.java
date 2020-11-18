package com.creation.controller.spring.post;

import com.creation.controller.spring.SController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Controller
@Lazy
public class CreateUserByOperatorSC extends SController {

    Logger logger = LogManager.getLogger(CreateUserByOperatorSC.class.getSimpleName());

    public boolean createUser(String email, String pass, String doublePass) {
        Mono<String> authMono = webClient
                .method(HttpMethod.POST)
                .uri("/users")
                .body(Mono.just(
                        "{" +
                                "\"email\": \"" + email + "\",\n" +
                                "\"first_name\": \"" + pass + "\",\n" +
                                "\"last_name\": \"" + doublePass + "\"" +
                                "}"), String.class).exchange().flatMap(clientResponse -> {
                    if (clientResponse.statusCode().isError()) {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(String.class);
                }).onErrorResume(e -> Mono.just("Error" + e.getMessage()));
        return getResult(authMono);
    }

    private boolean getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return false;
        } else
            return true;
    }

    private void error(String error) {
        logger.error("Failed registration... " + error);
    }
}
