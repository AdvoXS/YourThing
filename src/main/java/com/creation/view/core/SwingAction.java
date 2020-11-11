package com.creation.view.core;

import com.creation.view.frames.ErrorDialog;

public class SwingAction {
    public static void displayError(String head, String text) {
        createErrorDialog().setErrorText(head, text);
    }

    public static void displayError(String text) {
        createErrorDialog().setErrorText(text);
    }

    private static ErrorDialog createErrorDialog() {
        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.setVisible(true);
        return errorDialog;
    }
}
