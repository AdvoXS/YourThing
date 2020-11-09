package com.creation.controllers.core.executor;

import com.creation.controllers.core.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class RestExecutor {

    Controller controller;
    @Autowired
    ApplicationContext context;

    abstract void run();

    abstract void getResponseInfo();
}
