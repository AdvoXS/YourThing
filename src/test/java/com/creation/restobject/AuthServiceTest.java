package com.creation.restobject;

import com.creation.controller.spring.post.OperatorLoginSC;
import com.creation.core.application.App;
import com.creation.core.application.AppConst;
import com.creation.core.application.SpringApplicationConfig;
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
        App.getObjectCache().put(AppConst.OBJECT_AUTH, auth);
        assert App.getObjectCache().size() != 0;
    }
}