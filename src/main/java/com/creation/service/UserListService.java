package com.creation.service;

import com.creation.controller.spring.get.UserListSC;
import com.creation.core.application.UserException;
import com.creation.entity.Auth;
import com.creation.entity.User;
import com.creation.view.core.SwingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UserListService {
    @Autowired
    ApplicationContext con;

    @Autowired
    Auth auth;

    @Autowired
    UserException exc;

    public ArrayList<User> getAllUsers() {
        return getUsers();
    }

    public ArrayList<User> filterByName(String str) {
        return (ArrayList<User>) getUsers().stream().filter(e -> e.getFirst_name() != null && e.getFirst_name().contains(str)).collect(Collectors.toList());

    }

    public ArrayList<User> filterBySecondName(String str) {
        return (ArrayList<User>) getUsers().stream().filter(e -> e.getLast_name() != null && e.getLast_name().contains(str)).collect(Collectors.toList());
    }

    public ArrayList<User> filterByEmail(String str) {
        return (ArrayList<User>) getUsers().stream().filter(e -> e.getEmail() != null && e.getEmail().contains(str)).collect(Collectors.toList());
    }

    public ArrayList<User> filterUser(String name, String sName, String mail) {
        Predicate<User> namePred = s -> s.getFirst_name() != null && name != null && s.getFirst_name().contains(name);
        Predicate<User> sNamePred = s -> s.getLast_name() != null && sName != null && s.getLast_name().contains(sName);
        Predicate<User> mailPred = s -> s.getEmail() != null && mail != null && s.getEmail().contains(mail);
        return (ArrayList<User>) getUsers().stream().filter(namePred.and(sNamePred).and(mailPred)).collect(Collectors.toList());
    }


    private ArrayList<User> getUsers() {
        if (auth.isOperator()) {
            UserListSC contr = con.getBean(UserListSC.class);
            return contr.getList().getUserList();
        } else try {
            throw new Exception("Недостаточно прав");
        } catch (Exception e) {
            con.getBean(SwingAction.class).displayError(e.getMessage());
        }
        return new ArrayList<>();
    }

}
