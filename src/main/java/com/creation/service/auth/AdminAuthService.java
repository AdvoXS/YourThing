package com.creation.service.auth;

import com.creation.controller.spring.login.AdminLoginSC;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Lazy
public class AdminAuthService extends AuthService {

    public boolean initAuth(String mail, String pass) {
        if (!StringUtils.isEmpty(mail) || !StringUtils.isEmpty(pass)) {
            AdminLoginSC adminControl = con.getBean(AdminLoginSC.class);
            Auth auth = adminControl.getAuth(mail, pass);
            return getAuth(auth, Role.ADMIN);
        } else return false;
    }
}
