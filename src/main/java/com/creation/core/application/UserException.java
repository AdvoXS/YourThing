package com.creation.core.application;

import com.creation.view.core.SwingAction;


public class UserException extends RuntimeException {

    SwingAction swingAction;

    public UserException(String mes) {
        super(mes);
        //swingAction.displayError("Ошибка пользователя", mes);
    }
}
