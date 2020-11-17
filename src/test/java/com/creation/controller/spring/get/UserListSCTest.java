package com.creation.controller.spring.get;

import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.entity.UsersList;
import com.creation.service.AuthService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserListSCTest {
    ApplicationContext con;

    @Mock
    UserListSC listSC;

    @Before
    public void getAuth() {
        con = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        AuthService service = con.getBean(AuthService.class);
        service.initAuth("operator@test.ru", "12345678");
    }

    @Test
    public void getList() {
        when(listSC.getList()).thenReturn(new UsersList());
        UserListSC userListSC = con.getBean(UserListSC.class);
        UsersList users = userListSC.getList();
        Assert.assertNotNull(users);
    }

}