package com.creation.controller.spring.post;

import com.creation.core.config.SpringApplicationConfig;
import com.creation.restobject.Auth;
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
        Auth auth = context.getBean(Auth.class);
        Assert.assertNotNull(auth);
    }
}