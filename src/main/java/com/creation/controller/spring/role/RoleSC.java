package com.creation.controller.spring.role;

import com.creation.controller.spring.SController;
import com.creation.entity.Auth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class RoleSC extends SController {

    Logger logger = LogManager.getLogger(RoleSC.class.getSimpleName());

    @Autowired
    Auth auth;

    protected void error(String error) {
        logger.error("Failed get role(s) user... " + error);
    }
}
