package com.creation.controller.spring.admin;

import com.creation.core.application.Rests;
import com.creation.entity.AdminsList;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;
@Controller
@Lazy
public class AdminListSC extends AdminSC {
    @Autowired
    AdminsList adminsList;

    public AdminsList getList() {
        Mono<String> authMono = webClient
                .method(HttpMethod.GET)
                .uri("/admins")
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

    private AdminsList getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return null;
        } else {
            adminsList = new Gson().fromJson(result, AdminsList.class);
        }
        return adminsList;
    }
}
