package com.creation.controller.spring.get;

import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.service.AuthService;
import com.creation.service.UsersList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserListSCTest {
    ApplicationContext con;

    @Before
    public void getAuth() {
        con = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        AuthService service = con.getBean(AuthService.class);
        service.initAuth("operator@test.ru", "12345678");
    }

    @Test
    public void getList() {
        UserListSC userListSC = con.getBean(UserListSC.class);
        UsersList users = userListSC.getList();
        Assert.assertNotNull(users);
    }

}