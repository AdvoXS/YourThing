package com.creation.service;

import com.creation.controller.spring.delete.DeleteUserSC;
import com.creation.entity.Auth;
import com.creation.entity.User;
import com.creation.view.core.SwingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {
    @Autowired
    DeleteUserSC contr;
    @Autowired
    Auth auth;
    @Autowired
    SwingAction swingAction;

    public boolean delete(User user) {
        if (auth.isOperator()) {
            return contr.deleteUser(user);
        } else {
            swingAction.displayError("Недостаточно прав");
            return false;
        }
    }
}
