package com.creation.service.auth;

import com.creation.entity.Auth;
import com.creation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public abstract class AuthService {

    @Autowired
    protected ApplicationContext con;

    protected boolean getAuth(Auth auth, Role role) {
        if (auth != null) {
            Auth glAuth = con.getBean(Auth.class);
            glAuth.setToken(auth.getToken());
            glAuth.setUser(auth.getUser());
            glAuth.getUser().setRole(role);
            return true;
        } else return false;
    }

    public abstract boolean initAuth(String mail, String pass);
}
