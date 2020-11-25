package com.creation.core.application;

import javax.swing.*;

public class UserException extends RuntimeException {

    public UserException(String mes) {
        super(mes);
        JOptionPane.showMessageDialog(null, mes, "Ошибка пользователя", JOptionPane.ERROR_MESSAGE);
    }
}
