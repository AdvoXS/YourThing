package com.creation.service.user;

import com.creation.controller.spring.operator.CreateUserByOperatorSC;
import com.creation.core.application.UserException;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CreateUserService extends UserService{
    @Autowired
    CreateUserByOperatorSC contr;
    @Autowired
    Auth auth;

    public boolean createUser(String mail, String pass, String x2Pass) {
        if (!StringUtils.isEmpty(mail) && !StringUtils.isEmpty(pass) && !StringUtils.isEmpty(x2Pass)) {
            if (auth.getUser().getRole().equals(Role.OPERATOR))
                return contr.createUser(mail, pass, x2Pass);
            else throw new UserException("Недостаточно прав");
        } else throw new UserException("Необходимо заполнить все поля!");
    }
}
