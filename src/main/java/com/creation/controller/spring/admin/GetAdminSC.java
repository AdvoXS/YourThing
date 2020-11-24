package com.creation.controller.spring.admin;

import com.creation.core.application.Rests;
import com.creation.entity.User;
import com.google.gson.Gson;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;
@Controller
@Lazy
public class GetAdminSC extends AdminSC {

    public User getAdmin(int id) {
        Mono<String> authMono = webClient
                .method(HttpMethod.GET)
                .uri("/admins/"+id)
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

    private User getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return null;
        } else {
            return new Gson().fromJson(result, User.class);
        }
    }

}
