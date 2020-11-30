package com.creation.service.user;

import com.creation.controller.spring.user.UserUpdateSC;
import com.creation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserUpdateService extends UserService{
    @Autowired
    UserUpdateSC contr;


    public User updateUser(User user, HashMap<String, String> params) {
        if (user != null) {
            user.setFirst_name(params.get("name"));
            user.setLast_name(params.get("second_name"));
            user.setEmail(params.get("email"));
            String resultStr = contr.updateUser(user);
            if (!resultStr.equals("Complete")) {
                throw new RuntimeException("Ошибка изменения пользователя. " + resultStr);
            }
            return user;
        } else throw new RuntimeException("не удалось изменить пользователя, т.к. пользователь не был опознан");
    }
}
