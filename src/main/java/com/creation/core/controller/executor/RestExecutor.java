package com.creation.core.controller.executor;

import com.creation.core.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class RestExecutor {

    Controller controller;
    @Autowired
    ApplicationContext context;

    abstract void run();

    abstract void getResponseInfo();
}
