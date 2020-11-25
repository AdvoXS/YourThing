package com.creation.service.admin;

import com.creation.controller.spring.admin.GetAdminSC;
import com.creation.core.application.UserException;
import com.creation.entity.Role;
import com.creation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class GetAdminService extends AdminService{
    @Autowired
    GetAdminSC contr;

    public User getAdmin(int id) {
        if (auth.getUser().getRole().equals(Role.OPERATOR)) {
            User user = contr.getAdmin(id);
            if (user != null) return user;
            else throw new UserException("Ошибка получения данных администратора с id=" + id);
        }
        else throw new UserException("Недостаточно прав");
    }
}
