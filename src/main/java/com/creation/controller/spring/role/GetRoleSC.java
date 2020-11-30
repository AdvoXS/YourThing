package com.creation.controller.spring.role;

import com.creation.controller.spring.SController;
import com.creation.core.application.Rests;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Controller
@Lazy
public class GetRoleSC extends RoleSC {

    public Role geRole(int id) {
        Mono<String> authMono = webClient
                .method(HttpMethod.GET)
                .uri("/users/" + id + "/user_roles")
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

    private Role getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return null;
        } else {
            return new Gson().fromJson(result, Role.class);
        }
    }


}
