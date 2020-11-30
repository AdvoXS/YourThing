package com.creation.view.frames;

import com.creation.service.user.CreateUserService;
import com.creation.view.core.SwingProps;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@Lazy
public class AddProfile extends JFrame {
    final
    ApplicationContext context;
    private JTextField textField1;
    private JLabel emailLabel;
    private JButton createButton;
    private JPanel mainPanel;
    private JTextField passTField;
    private JTextField confirmPassTField;

    public AddProfile(ApplicationContext context) {
        setTitle("Создать учетную запись");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setContentPane(mainPanel);
        int sizeWidth = 400;
        int sizeHeight = 170;
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        SwingProps.setStartWindowCenter(this, sizeWidth, sizeHeight);
        pack();
        this.context = context;
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        createButton = new JButton();
        textField1 = new JTextField();
        passTField = new JTextField();
        confirmPassTField = new JTextField();
        createButton.addActionListener(e ->
                context.getBean(CreateUserService.class).createUser(textField1.getText(), passTField.getText(), confirmPassTField.getText())
        );
    }
}
