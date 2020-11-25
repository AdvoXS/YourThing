package com.creation.service;

import com.creation.controller.spring.user.SignUpSC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService {
    @Autowired
    SignUpSC signUp;

    public boolean initReg(String email, String pass, String doublePass) {
        return signUp.getReg(email, pass, doublePass);
    }
}
