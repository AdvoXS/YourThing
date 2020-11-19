package com.creation.view.frames;

import com.creation.service.AuthService;
import com.creation.view.core.SwingAction;
import com.creation.view.core.SwingProps;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@Lazy
public class LoginFrame extends JFrame {
    final
    ApplicationContext context;

    private JTextField loginField;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JButton enterButton;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JLabel registerLabel;

    public LoginFrame(ApplicationContext context) {
        setTitle("Your Things");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        int sizeWidth = 400;
        int sizeHeight = 150;
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        SwingProps.setStartWindowCenter(this, sizeWidth, sizeHeight);
        pack();
        this.context = context;
    }


    private void createUIComponents() {
        enterButton = new JButton();
        cancelButton = new JButton();
        loginField = new JTextField();
        passwordField = new JPasswordField();
        enterButton.addActionListener((e) -> {
            String mail = loginField.getText();
            String pass = String.valueOf(passwordField.getPassword());
            if (context.getBean(AuthService.class).initAuth(mail, pass)) {
                startApp();
            } else {
                SwingAction swAction = context.getBean(SwingAction.class);
                swAction.displayError("Ошибка авторизации. Проверьте правильность ввода пароля и почты");
            }
        });
        cancelButton.addActionListener(e -> System.exit(0));
        registerButton = new JButton();
        registerButton.addActionListener(e -> {
            openRegister();
        });
        setTestAuthInfo();
    }

    public void setEMail(String mail) {
        loginField.setText(mail);
    }

    /**
     * only for test
     */
    private void setTestAuthInfo() {
        loginField.setText("operator@test.ru");
    }

    private void openRegister() {
        RegisterFrame registerFrame = context.getBean(RegisterFrame.class);
        registerFrame.setVisible(true);
        this.setVisible(false);
    }

    private void startApp() {
        MainFrame mainframe = context.getBean(MainFrame.class);
        mainframe.setVisible(true);
        this.setVisible(false);
    }

}
