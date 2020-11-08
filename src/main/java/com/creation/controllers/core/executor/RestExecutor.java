package com.creation.controllers.core.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class RestExecutor {

    @Autowired
    ApplicationContext context;

    abstract void run();
}
