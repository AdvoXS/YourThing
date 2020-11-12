package com.creation.controller.spring.post;

import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.restobject.auth.Auth;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OperatorLoginSCTest {
    ApplicationContext context;

    @Before
    public void setContext() {
        context = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
    }

    @Test
    public void getAuthObject() {
        Auth auth = context.getBean(Auth.class, "123213", "2332");
        Assert.assertNotNull(auth);
    }
}