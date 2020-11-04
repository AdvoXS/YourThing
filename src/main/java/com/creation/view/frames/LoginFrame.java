package com.creation.view.frames;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame{
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JPanel mainPanel;
    private JPasswordField passwordField1;

    public LoginFrame(){
        setTitle("Your Things");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 400));
        pack();
    }
}
