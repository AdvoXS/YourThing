package com.creation.controller.spring.shop;

import com.creation.controller.spring.SController;
import com.creation.entity.Auth;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class ShopSC extends SController {
    Logger logger = LogManager.getLogger(ShopSC.class.getSimpleName());

    @Autowired
    Auth auth;

    protected void error(String error) {
        logger.error(error);
    }
}
