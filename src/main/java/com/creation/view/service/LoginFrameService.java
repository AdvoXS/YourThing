package com.creation.view.service;

import com.creation.core.utils.Property;
import com.creation.service.auth.AdminAuthService;
import com.creation.service.auth.OperatorAuthService;
import com.creation.service.auth.UserAuthService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class LoginFrameService {

    public static void initIsAdminCBox(Property property, JComboBox<String> comboBox) {
        if (Boolean.parseBoolean(property.getProperty("operator.mode"))) {
            comboBox.addItem("Admin");
            comboBox.addItem("Operator");
            comboBox.setVisible(true);
        } else comboBox.setVisible(false);
    }

    public static boolean authentication(ApplicationContext context, JComboBox<String> box, String login, String pass) {
        if (box.isVisible()) {
            switch (box.getSelectedIndex()) {
                case 0:
                    return context.getBean(AdminAuthService.class).initAuth(login, pass);
                case 1:
                    return context.getBean(OperatorAuthService.class).initAuth(login, pass);
                default:
                    return false;
            }
        } else return context.getBean(UserAuthService.class).initAuth(login, pass);
    }
}
