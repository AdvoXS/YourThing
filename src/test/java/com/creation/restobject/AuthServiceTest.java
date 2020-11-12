package com.creation.restobject;

import com.creation.controller.spring.post.OperatorLoginSC;
import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.restobject.auth.Auth;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AuthServiceTest {
    @Test
    public void getAndCacheAuth() {
        ApplicationContext con = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        OperatorLoginSC loginControl = con.getBean(OperatorLoginSC.class);
        Auth auth = loginControl.getAuth("operator@test.ru", "12345678");
        Assert.assertNotNull(auth);
    }
}