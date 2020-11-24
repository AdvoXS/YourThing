package com.creation.controller.spring.admin.post;

import com.creation.controller.spring.admin.CreateAdminSC;
import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.entity.Auth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringApplicationConfig.class})
public class CreateGetAdminSCTest {
    @Autowired
    CreateAdminSC contr;
    @Autowired
    Auth auth;

    @Test
    public void test() {
        auth.setToken("ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKMWRXbGtJam9pWVdZeU4yWTNNMlF0WldaaFl5MDBNbU0zTFdFeE1qTXRORE0wWVRRek1qVXpZbVJtSWl3aWIzZHVaWElpT25zaWFXUWlPakY5TENKMGFXMWxjM1JoYlhBaU9pSXlNREl3TFRFeExUSTBWREUyT2pBeU9qQTFXaUlzSW10cGJtUWlPaUp6WlhOemFXOXVjeTl2ZDI1bGNuTXZiM0JsY21GMGIzSWlmUS5LMEpsV2Raa19yMkZ1SzRBX0pMMFN5ckRxMFh1a0kzWWJDNlF3ZjNuUHdr");
        assert contr.createAdmin("admin@mail.ru", "12345678", "12345678");
    }
}