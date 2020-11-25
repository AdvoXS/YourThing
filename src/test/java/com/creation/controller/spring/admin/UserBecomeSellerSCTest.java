package com.creation.controller.spring.admin;

import com.creation.controller.spring.role.RoleSC;
import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.entity.Auth;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringApplicationConfig.class})
public class UserBecomeSellerSCTest {
    @Autowired
    UserBecomeSellerSC contr;

    @Autowired
    RoleSC roleSC;

    @Autowired
    Auth auth;
    @BeforeClass
    public static void init() {

    }
    @Test
    public void test(){
        auth.setToken("none=");
        contr.becomeSeller(11);
       // Assert.assertNotEquals(roleSC.geRole(11).getCode(),0);
    }
}