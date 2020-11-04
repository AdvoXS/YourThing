package com.creation.view.elements;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Highlighted TextField
 */
public class HTextField extends JTextField {
    public HTextField(final String propText) {
        super(propText);
        addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().isEmpty()) {
                    setText(propText);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(propText)) {
                    setText("");
                }
            }
        });

    }

}
