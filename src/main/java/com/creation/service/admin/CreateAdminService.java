package com.creation.service.admin;

import com.creation.controller.spring.admin.CreateAdminSC;
import com.creation.core.application.UserException;
import com.creation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CreateAdminService extends AdminService{

    @Autowired
    private CreateAdminSC contr;

    public boolean create(String mail, String pass, String x2Pass){
        if(auth.getUser().getRole().equals(Role.OPERATOR)){
           return contr.createAdmin(mail, pass, x2Pass);
        }
        else throw new UserException("Недостаточно прав");
    }
}
