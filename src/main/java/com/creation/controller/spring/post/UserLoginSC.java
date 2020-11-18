package com.creation.controller.spring.post;

import com.creation.controller.spring.SController;
import com.creation.entity.Auth;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Controller
public class UserLoginSC extends SController {
    Logger logger = LogManager.getLogger(OperatorLoginSC.class.getSimpleName());

    public Auth getAuth(String email, String pass) {
        Mono<String> authMono = webClient
                .method(HttpMethod.POST)
                .uri("/users/login")
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

    private Auth getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return null;
        } else
            return new Gson().fromJson(result, Auth.class);
    }

    private void error(String error) {
        logger.error("Failed authorization... " + error);
    }
}
