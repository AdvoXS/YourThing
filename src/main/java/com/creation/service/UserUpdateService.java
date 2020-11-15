package com.creation.service;

import com.creation.controller.spring.patch.UserUpdateSC;
import com.creation.entity.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserUpdateService {
    @Autowired
    UserUpdateSC contr;

    @Autowired
    Gson parser;

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
