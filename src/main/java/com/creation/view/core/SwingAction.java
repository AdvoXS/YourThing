package com.creation.view.core;

import com.creation.view.frames.ErrorDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SwingAction {
    @Autowired
    ErrorDialog dialog;

    public void displayError(String head, String text) {
        dialog.setErrorText(head, text);
        dialog.setVisible(true);
    }

    public void displayError(String text) {
        dialog.setErrorText(text);
        dialog.setVisible(true);
    }
}
