package com.creation.controller.spring.login;

import com.creation.controller.spring.SController;
import com.creation.core.application.UserException;
import com.creation.entity.Auth;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

public abstract class LoginSC extends SController {
    Logger logger = LogManager.getLogger(LoginSC.class.getSimpleName());

    public abstract Auth getAuth(String email, String pass);

    protected Auth getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return null;
        } else
            return new Gson().fromJson(result, Auth.class);
    }

    private void error(String error) {
        logger.error("Failed authorization... " + error);
        throw new UserException("Ошибка авторизации. Проверьте правильность введенных данных!");
    }
}
