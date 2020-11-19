package com.creation.service;

import com.creation.controller.spring.post.OperatorLoginSC;
import com.creation.controller.spring.post.UserLoginSC;
import com.creation.core.utils.Property;
import com.creation.entity.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AuthService {
    @Autowired
    ApplicationContext con;


    public boolean initAuth(String mail, String pass) {
        Property prop = con.getBean(Property.class);
        boolean isOperator = Boolean.parseBoolean(prop.get("operator.mode").toString());
        return initAuth(isOperator, mail, pass);
    }

    private boolean initAuth(boolean isOperator, String mail, String pass) {
        if (!StringUtils.isEmpty(mail) || !StringUtils.isEmpty(pass)) {
            Auth auth;
            if (isOperator) {
                OperatorLoginSC loginControl = con.getBean(OperatorLoginSC.class);
                auth = loginControl.getAuth(mail, pass);
            } else {
                UserLoginSC loginControl = con.getBean(UserLoginSC.class);
                auth = loginControl.getAuth(mail, pass);
            }
            if (auth != null) {
                Auth glAuth = con.getBean(Auth.class);
                glAuth.setToken(auth.getToken());
                glAuth.setUser(auth.getUser());
                glAuth.setOperator(isOperator);
                return true;
            } else return false;
        }
        return false;
    }
}

