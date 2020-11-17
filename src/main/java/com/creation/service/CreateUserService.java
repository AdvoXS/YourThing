package com.creation.service;

import com.creation.controller.spring.post.CreateUserByOperatorSC;
import com.creation.entity.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {
    @Autowired
    CreateUserByOperatorSC contr;
    @Autowired
    Auth auth;

    public boolean createUser(String mail, String pass, String x2Pass) {
        if (auth.isOperator())
            return contr.createUser(mail, pass, x2Pass);
        else throw new RuntimeException("Недостаточно прав");
    }
}
