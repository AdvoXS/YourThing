package com.creation.controller.spring.user;

import com.creation.controller.spring.SController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

public class UserToSeller extends SController {
    Logger logger = LogManager.getLogger(UserToSeller.class.getSimpleName());

    public boolean becomeSeller(int id) {
        Mono<String> authMono = webClient
                .method(HttpMethod.POST)
                .uri("/users/" + id + "/user_roles/3/activate")
                .body(Mono.just(
                        "{}"), String.class).exchange().flatMap(clientResponse -> {
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
        logger.error("Failed activate seller role... " + error);
    }
}
