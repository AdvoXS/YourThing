package com.creation.service.user;

import com.creation.controller.spring.operator.CreateUserByOperatorSC;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService extends UserService{
    @Autowired
    CreateUserByOperatorSC contr;
    @Autowired
    Auth auth;

    public boolean createUser(String mail, String pass, String x2Pass) {
        if (auth.getUser().getRole().equals(Role.OPERATOR))
            return contr.createUser(mail, pass, x2Pass);
        else throw new RuntimeException("Недостаточно прав");
    }
}
