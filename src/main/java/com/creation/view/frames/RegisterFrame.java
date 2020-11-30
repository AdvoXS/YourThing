package com.creation.view.frames;

import com.creation.service.user.RegService;
import com.creation.view.core.SwingProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.swing.*;
import java.awt.*;

@Component
@Lazy
public class RegisterFrame extends AbstractFrame {
    @Autowired
    ApplicationContext context;

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton registerButton;
    private JButton cancelButton;
    private JPanel trPanel;
    private JPanel mainPanel;

    public RegisterFrame() {
        setTitle("Registration");
        setContentPane(mainPanel);
        int sizeWidth = 400;
        int sizeHeight = 200;
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        SwingProps.setStartWindowCenter(this, sizeWidth, sizeHeight);
        pack();
    }

    private void createUIComponents() {
        setsRegButton();
        setsCancelButton();
    }

    private void setsRegButton() {
        registerButton = new JButton();
        registerButton.addActionListener(e -> {
            String mail = textField1.getText();
            String pass1 = String.valueOf(passwordField1.getPassword());
            String pass2 = String.valueOf(passwordField2.getPassword());
            if (context.getBean(RegService.class).initReg(mail, pass1, pass2)) {
                backToLogin();
                clearUI();
            } else {
                displayErrorDialog("Ошибка регистрации", "Введены некорректные значения");
            }
        });
    }

    private void setsCancelButton() {
        cancelButton = new JButton();
        cancelButton.addActionListener(e -> {
            backToLogin();
            clearUI();
        });
    }

    private void backToLogin() {
        LoginFrame lf = context.getBean(LoginFrame.class);
        if (!StringUtils.isEmpty(textField1.getText()))
            lf.setEMail(textField1.getText());
        lf.setVisible(true);
        this.setVisible(false);
    }

    private void clearUI() {
        textField1.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }

}
