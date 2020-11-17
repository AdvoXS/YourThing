package com.creation.view.frames;

import com.creation.view.core.SwingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.HashMap;

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

    public void visible(boolean isVisible, HashMap<String, Object> params) {
        setVisible(true);
    }

    public void visible(boolean isVisible, Object obj) {
        setVisible(true);
    }
}
