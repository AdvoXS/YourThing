package com.creation.core.controller.post;

import com.creation.core.controller.service.PostService;
import com.creation.restobject.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public abstract class AuthorizationPostController extends PostService {
    @Autowired
    Auth auth;

    Logger logger = Logger.getLogger(AuthorizationPostController.class.getSimpleName());

    protected void getToken() {
        if (getResponseInfo() != null) {
            Auth tmpA;
            tmpA = parser.fromJson(getResponseInfo(), Auth.class);
            auth.setToken(tmpA.getToken());
        }
    }

    @Override
    public void send() {
        super.send();
        if (response.getStatusLine().getStatusCode() == 200)
            logger.info("Authorization was successful!");
    }

    @Override
    public void postProcess() {
        getToken();
    }
}
