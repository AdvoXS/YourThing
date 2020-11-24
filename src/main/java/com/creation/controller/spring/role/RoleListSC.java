package com.creation.controller.spring.role;

import com.creation.controller.spring.SController;
import com.creation.core.application.Rests;
import com.creation.entity.Auth;
import com.creation.entity.RolesList;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

public class RoleListSC extends SController {

    @Autowired
    Auth auth;

    @Autowired
    RolesList roles;

    Logger logger = LogManager.getLogger(RoleListSC.class.getSimpleName());

    public RolesList getRoleList() {
        Mono<String> authMono = webClient
                .method(HttpMethod.GET)
                .uri("/users/user_role")
                .headers(headers -> {
                    headers.set(Rests.CONTENT_TYPE, Rests.APPLICATION_JSON_VALUE);
                    headers.set(Rests.X_ACCESS_TOKEN, auth.getToken());
                })
                .exchange().flatMap(clientResponse -> {
                    if (clientResponse.statusCode().isError()) {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(String.class);
                }).onErrorResume(e -> Mono.just("Error" + e.getMessage()));
        return getResult(authMono);
    }

    private RolesList getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return null;
        } else {
            roles = new Gson().fromJson(result, RolesList.class);
        }
        return roles;
    }

    private void error(String error) {
        logger.error("Failed get list roles... " + error);
    }
}
