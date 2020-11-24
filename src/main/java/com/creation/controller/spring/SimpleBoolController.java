package com.creation.controller.spring;

import com.creation.core.application.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;
@Controller
public class SimpleBoolController extends SController {

    protected boolean getResult(Mono<String> authMono) {
        String result = authMono.block();
        if (!StringUtils.isEmpty(result) && result.contains("Error")) {
            error(result);
            return false;
        } else
            return true;
    }

    protected void error(String error) {
        throw new UserException(error);
    }
}
