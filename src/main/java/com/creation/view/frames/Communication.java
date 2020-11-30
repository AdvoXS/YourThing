package com.creation.view.frames;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;


@Component
@Lazy
public class Communication extends JFrame {
    private JPanel mainPanel;
    private JTextArea textArea1;
    public Communication(){
        setTitle("Contact");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 500));
        pack();
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        textArea1 = new JTextArea();
    }
}
