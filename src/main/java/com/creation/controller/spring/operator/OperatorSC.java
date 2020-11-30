package com.creation.controller.spring.operator;

import com.creation.controller.spring.SController;
import com.creation.entity.Auth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class OperatorSC extends SController {
    @Autowired
    Auth auth;
    Logger logger = LogManager.getLogger(CreateUserByOperatorSC.class.getSimpleName());

    protected void error(String error) {
        logger.error("Failed registration... " + error);
    }
}
