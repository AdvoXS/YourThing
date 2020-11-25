package com.creation.controller.spring.admin;

import com.creation.core.application.Rests;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Controller
@Lazy
public class UpdateAdminSC extends AdminSC {

    public boolean updateAdmin(int id, String phone, String fName, String sName) {
        Mono<String> authMono = webClient
                .method(HttpMethod.PATCH)
                .uri("/admins/" + id)
                .headers(headers -> {
                    headers.set(Rests.CONTENT_TYPE, Rests.APPLICATION_JSON_VALUE);
                    headers.set(Rests.X_ACCESS_TOKEN, auth.getToken());
                })
                .body(Mono.just(
                        "{" +
                                "\"phone\": \"" + phone + "\",\n" +
                                "\"first_name\": \"" + fName + "\",\n" +
                                "\"last_name\": \"" + sName + "\"" +
                                "}"), String.class).exchange().flatMap(clientResponse -> {
                    if (clientResponse.statusCode().isError()) {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(String.class);
                }).onErrorResume(e -> Mono.just("Error" + e.getMessage()));
        return getResult(authMono);
    }

    protected boolean getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return false;
        } else
            return true;
    }
}
