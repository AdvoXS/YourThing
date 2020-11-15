package com.creation.controller.spring.patch;

import com.creation.controller.spring.SController;
import com.creation.core.application.Rests;
import com.creation.entity.Auth;
import com.creation.entity.User;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Controller
public class UserUpdateSC extends SController {
    @Autowired
    Auth auth;

    @Autowired
    Gson parser;

    Logger logger = LogManager.getLogger(UserUpdateSC.class.getSimpleName());

    public String updateUser(User updatedUser) {
        String jsonPatch = parser.toJson(updatedUser);
        Mono<String> updateUserMono = webClient.method(HttpMethod.PATCH)
                .uri("/users/" + updatedUser.getId())
                .headers(headers -> {
                    headers.set(Rests.CONTENT_TYPE, Rests.APPLICATION_JSON_VALUE);
                    headers.set(Rests.X_ACCESS_TOKEN, auth.getToken());
                })
                .body(Mono.just(jsonPatch), String.class).exchange().flatMap(clientResponse -> {
                    if (clientResponse.statusCode().isError()) {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(String.class);
                }).onErrorResume(e -> Mono.just("Error" + e.getMessage()));
        return getResult(updateUserMono);
    }

    private String getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return result;
        } else
            return "Complete";
    }

    private void error(String error) {
        logger.error("Failed updates user... " + error);
    }
}
