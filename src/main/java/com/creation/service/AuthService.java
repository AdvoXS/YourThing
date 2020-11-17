package com.creation.service;

import com.creation.controller.spring.post.OperatorLoginSC;
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
        if (!StringUtils.isEmpty(mail) || !StringUtils.isEmpty(pass)) {
            OperatorLoginSC loginControl = con.getBean(OperatorLoginSC.class);
            Auth auth = loginControl.getAuth(mail, pass);
            if (auth != null) {
                Auth glAuth = con.getBean(Auth.class);
                glAuth.setToken(auth.getToken());
                glAuth.setUser(auth.getUser());
                return true;
            } else return false;
        }
        return false;
    }
}