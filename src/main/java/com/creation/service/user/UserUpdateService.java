package com.creation.service.user;

import com.creation.controller.spring.user.UserUpdateSC;
import com.creation.core.application.UserException;
import com.creation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

@Service
public class UserUpdateService extends UserService{
    @Autowired
    UserUpdateSC contr;


    public User updateUser(User user, HashMap<String, String> params) {
        String name = params.get("name");
        String sName = params.get("second_name");
        String email = params.get("email");
        if (user != null && !StringUtils.isEmpty(name) && !StringUtils.isEmpty(sName) && !StringUtils.isEmpty(email)) {
            user.setFirst_name(name);
            user.setLast_name(sName);
            user.setEmail(email);
            String resultStr = contr.updateUser(user);
            if (!resultStr.equals("Complete")) {
                throw new UserException("Ошибка изменения пользователя. " + resultStr);
            }
            return user;
        } else throw new UserException("Необходимо заполнить обязательные поля: Имя, Фамилия, Email!");
    }
}
