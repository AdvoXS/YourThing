package com.creation.service.admin;

import com.creation.controller.spring.admin.DeleteAdminSC;
import com.creation.core.application.UserException;
import com.creation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class DeleteAdminService extends AdminService{
    @Autowired
    DeleteAdminSC contr;

    public boolean delete(int id){
        if(auth.getUser().getRole().equals(Role.OPERATOR)){
            return contr.deleteAdmin(id);
        }
        else throw new UserException("Недостаточно прав");
    }
}
