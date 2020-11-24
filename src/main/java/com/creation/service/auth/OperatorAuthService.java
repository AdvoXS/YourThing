package com.creation.service.auth;

import com.creation.controller.spring.login.OperatorLoginSC;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Lazy
public class OperatorAuthService extends AuthService {

    public boolean initAuth(String mail, String pass) {
        if (!StringUtils.isEmpty(mail) || !StringUtils.isEmpty(pass)) {
            OperatorLoginSC operatorControl = con.getBean(OperatorLoginSC.class);
            Auth auth = operatorControl.getAuth(mail, pass);
            return getAuth(auth, Role.OPERATOR);
        } else return false;
    }
}