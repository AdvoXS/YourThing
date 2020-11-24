package com.creation.controller.spring.user;

import com.creation.controller.spring.SController;
import com.creation.core.application.Rests;
import com.creation.entity.Auth;
import com.creation.entity.User;
import com.creation.view.core.SwingAction;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

@Controller
@Lazy
public class DeleteUserSC extends SController {
    @Autowired
    Auth auth;

    @Autowired
    Gson parser;

    @Autowired
    SwingAction swingAction;

    Logger logger = LogManager.getLogger(UserUpdateSC.class.getSimpleName());

    public boolean deleteUser(User deletesUser) {
        String jsonPatch = parser.toJson(deletesUser);
        Mono<String> updateUserMono = webClient.method(HttpMethod.DELETE)
                .uri("/users/" + deletesUser.getId())
                .headers(headers -> {
                    headers.set(Rests.CONTENT_TYPE, Rests.APPLICATION_JSON_VALUE);
                    headers.set(Rests.X_ACCESS_TOKEN, auth.getToken());
                })
                .body(Mono.just("{}"), String.class).exchange().flatMap(clientResponse -> {
                    if (clientResponse.statusCode().isError()) {
                        return clientResponse.createException().flatMap(Mono::error);
                    }
                    return clientResponse.bodyToMono(String.class);
                }).onErrorResume(e -> Mono.just("Error" + e.getMessage()));
        return getResult(updateUserMono);
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
        String errorMsg = "Failed user delete... " + error;
        logger.error(errorMsg);
        swingAction.displayError(errorMsg);
    }
}
