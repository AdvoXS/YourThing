package com.creation.view.frames;

import com.creation.core.utils.Property;
import com.creation.view.core.SwingAction;
import com.creation.view.core.SwingProps;
import com.creation.view.service.LoginFrameService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@DependsOn({"loginFrameService"})
public class LoginFrame extends JFrame {
    final
    ApplicationContext context;
    final
    Property property;
    private JTextField loginField;
    private JButton cancelButton;
    private JPanel mainPanel;
    private JButton enterButton;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JComboBox<String> isAdminCBox;
    private JLabel registerLabel;

    public LoginFrame(ApplicationContext context, Property property) {
        setTitle("Your Things");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        int sizeWidth = 400;
        int sizeHeight = 170;
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        SwingProps.setStartWindowCenter(this, sizeWidth, sizeHeight);
        pack();
        this.context = context;
        this.property = property;
        postConstr();
    }

    private void postConstr(){
        if (Boolean.parseBoolean(property.getProperty("operator.mode"))) {
            isAdminCBox.addItem("Admin");
            isAdminCBox.addItem("Operator");
            isAdminCBox.setVisible(true);
        } else isAdminCBox.setVisible(false);
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        enterButton = new JButton();
        cancelButton = new JButton();
        loginField = new JTextField();
        passwordField = new JPasswordField();
        isAdminCBox = new JComboBox<>();
        enterButton.addActionListener((e) -> {
            String mail = loginField.getText();
            String pass = String.valueOf(passwordField.getPassword());
            if (LoginFrameService.authentication(context, isAdminCBox, mail, pass)) {
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
