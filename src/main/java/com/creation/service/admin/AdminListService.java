package com.creation.service.admin;

import com.creation.controller.spring.admin.AdminListSC;
import com.creation.core.application.UserException;
import com.creation.entity.Role;
import com.creation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@Lazy
public class AdminListService extends AdminService{
    @Autowired
    AdminListSC contr;

    public ArrayList<User> getUsers() {
        if (auth.getUser().getRole().equals(Role.OPERATOR)) {
            return contr.getList().getUserList();
        } else
            throw new UserException("Недостаточно прав");
    }
}
