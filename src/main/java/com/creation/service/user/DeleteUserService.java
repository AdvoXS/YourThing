package com.creation.service.user;

import com.creation.controller.spring.user.DeleteUserSC;
import com.creation.entity.Auth;
import com.creation.entity.Role;
import com.creation.entity.User;
import com.creation.view.core.SwingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService extends UserService{
    @Autowired
    DeleteUserSC contr;
    @Autowired
    Auth auth;
    @Autowired
    SwingAction swingAction;

    public boolean delete(User user) {
        if (auth.getUser().getRole().equals(Role.OPERATOR)) {
            return contr.deleteUser(user);
        } else {
            swingAction.displayError("Недостаточно прав");
            return false;
        }
    }
}
