package com.creation.view.frames;

import com.creation.view.core.SwingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AbstractFrame extends JFrame {
    @Autowired
    ApplicationContext con;

    public void displayErrorDialog(String text) {
        SwingAction sa = con.getBean(SwingAction.class);
        sa.displayError(text);
    }

    public void displayErrorDialog(String head, String text) {
        SwingAction sa = con.getBean(SwingAction.class);
        sa.displayError(head, text);
    }
}
