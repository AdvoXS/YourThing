package com.creation.view.frames;

import com.creation.restobject.AuthService;
import com.creation.view.core.SwingAction;
import com.creation.view.core.SwingProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class LoginFrame extends JFrame {
    @Autowired
    ApplicationContext context;
    private JTextField loginField;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JButton enterButton;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Your Things");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        int sizeWidth = 400;
        int sizeHeight = 150;
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        SwingProps.setStartWindowCenter(this, sizeWidth, sizeHeight);
        pack();
    }


    private void createUIComponents() {
        enterButton = new JButton();
        cancelButton = new JButton();
        enterButton.addActionListener((e) -> {
            String mail = loginField.getText();
            String pass = String.valueOf(passwordField.getPassword());
            if (context.getBean(AuthService.class).initAuth(mail, pass)) {
                startApp();
            } else {
                SwingAction.displayError("Ошибка авторизации. Проверьте правильность ввода пароля и почты");
            }
        });
    }

    private void startApp() {
        MainFrame mainframe = context.getBean(MainFrame.class);
        mainframe.setVisible(true);
        this.setVisible(false);
    }

}
