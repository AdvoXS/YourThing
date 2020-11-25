package com.creation.service.admin;

import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import com.creation.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringApplicationConfig.class})
public class CreateAdminServiceTest {
    @Autowired
    CreateAdminService service;
    @Autowired
    Auth auth;
    @Test
    public void create() {
        auth.setToken("none");
        auth.setUser(new User());
        auth.getUser().setRole(Role.OPERATOR);
        assert service.create("admin1@mail.ru","12345678","12345678");
    }
}