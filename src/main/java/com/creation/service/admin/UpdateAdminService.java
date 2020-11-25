package com.creation.service.admin;

import com.creation.controller.spring.admin.UpdateAdminSC;
import com.creation.core.application.UserException;
import com.creation.entity.Role;
import com.creation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateAdminService extends AdminService {

    @Autowired
    UpdateAdminSC contr;

    public boolean update(int id, String phone, String fName, String sName) {
        if (auth.getUser().getRole().equals(Role.OPERATOR)) {
            return contr.updateAdmin(id, phone, fName, sName);
        } else throw new UserException("Недостаточно прав");
    }

    public boolean update(User updatedUser) {
        if (auth.getUser().getRole().equals(Role.OPERATOR)) {
            return contr.updateAdmin(updatedUser.getId(), updatedUser.getPhone(), updatedUser.getFirst_name(), updatedUser.getLast_name());
        } else throw new UserException("Недостаточно прав");
    }
}
