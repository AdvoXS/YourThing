package com.creation.service.admin;

import com.creation.controller.spring.admin.AdminListSC;
import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import com.creation.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringApplicationConfig.class})
public class AdminListServiceTest {
    @Autowired
    AdminListSC service;
    @Autowired
    Auth auth;
    @Test
    public void getList() {
        auth.setToken("none");
        auth.setUser(new User());
        auth.getUser().setRole(Role.OPERATOR);
        ArrayList<User> u = service.getList().getUserList();
        assert !u.isEmpty();
    }
}