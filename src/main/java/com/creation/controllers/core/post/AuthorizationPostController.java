package com.creation.controllers.core.post;

import com.creation.controllers.core.service.PostService;
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
            auth = parser.fromJson(getResponseInfo(), Auth.class);
        }
    }

    @Override
    public void send() {
        super.send();
        if (response.getStatusLine().getStatusCode() == 200)
            logger.info("Authorization was successful!");

    }
}
