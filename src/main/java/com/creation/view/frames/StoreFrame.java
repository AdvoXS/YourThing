package com.creation.view.frames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
@Lazy
public class StoreFrame extends JFrame{
    final
    ApplicationContext context;
    private JButton contactButton;
    private JButton профильButton;
    private JButton изменитьButton;
    private JButton добавитьТоварButton;
    private JPanel mainPanel;

    public StoreFrame(ApplicationContext context){
        this.context = context;
        setTitle("Store");
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(600, 500));
        pack();
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        contactButton = new JButton();
        contactButton.addActionListener(e->
        {
            context.getBean(Communication.class).setVisible(true);
        });
    }
}
