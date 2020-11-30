package com.creation.service.auth;

import com.creation.controller.spring.login.UserLoginSC;
import com.creation.controller.spring.role.GetRoleSC;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Lazy
public class UserAuthService extends AuthService {
    @Autowired
    ApplicationContext con;
    Logger logger = LogManager.getLogger(UserAuthService.class.getSimpleName());

    public boolean initAuth(String mail, String pass) {
        if (!StringUtils.isEmpty(mail) || !StringUtils.isEmpty(pass)) {
            UserLoginSC loginControl = con.getBean(UserLoginSC.class);
            Auth auth = loginControl.getAuth(mail, pass);
            boolean isAuth = getAuth(auth, Role.USER);
           // setRole();
            return isAuth;
        }
        return false;
    }


    private void setRole() {
        GetRoleSC getRoleSC = con.getBean(GetRoleSC.class);
        Auth auth = con.getBean(Auth.class);
        Role role = getRoleSC.geRole(auth.getUser().getId());
        if (role != null) auth.getUser().setRole(Role.SELLER);
    }
}

