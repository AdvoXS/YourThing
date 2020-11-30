package com.creation.service.admin;

import com.creation.controller.spring.admin.UserBecomeSellerSC;
import com.creation.core.application.UserException;
import com.creation.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UserBecomeSellerService extends AdminService {
    @Autowired
    UserBecomeSellerSC contr;

    public boolean become() {
        if (auth.getUser().getRole().equals(Role.USER))
            return contr.becomeSeller(auth.getUser().getId());
        else throw new UserException("Становиться продавцом может только обычный пользователь!");
    }
}
