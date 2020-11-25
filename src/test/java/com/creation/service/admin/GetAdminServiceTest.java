package com.creation.service.admin;

import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import com.creation.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringApplicationConfig.class})
public class GetAdminServiceTest {
    @Autowired
    GetAdminService service;
    @Autowired
    Auth auth;
    @Test
    public void getAdmin() {
        auth.setToken("none");
        auth.setUser(new User());
        auth.getUser().setRole(Role.OPERATOR);
        User u = service.getAdmin (1);
        Assert.assertNotNull(u);
    }
}