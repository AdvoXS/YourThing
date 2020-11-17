package com.creation.service;

import com.creation.controller.spring.get.UserListSC;
import com.creation.entity.Auth;
import com.creation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UserListService {
    @Autowired
    ApplicationContext con;

    @Autowired
    Auth auth;

    public ArrayList<User> getAllUsers() {
        return getUsers();
    }

    public ArrayList<User> filterByName(String str) {
        return (ArrayList<User>) getUsers().stream().filter(e -> e.getFirst_name().contains(str)).collect(Collectors.toList());
    }

    public ArrayList<User> filterBySecondName(String str) {
        return (ArrayList<User>) getUsers().stream().filter(e -> e.getLast_name().contains(str)).collect(Collectors.toList());
    }

    public ArrayList<User> filterByEmail(String str) {
        return (ArrayList<User>) getUsers().stream().filter(e -> e.getEmail().contains(str)).collect(Collectors.toList());
    }

    private ArrayList<User> getUsers() {
        if (auth.isOperator()) {
            UserListSC contr = con.getBean(UserListSC.class);
            return contr.getList().getUserList();
        } else throw new RuntimeException("Недостаточно прав");
    }

}
