package com.creation.view.frames;

import com.creation.view.core.SwingProps;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@Component
public class ErrorDialog extends JDialog {
    private JPanel contentPane;
    private JLabel headerTextF;
    private JLabel descriptionTextF;
    private JButton buttonCancel;

    public ErrorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);
        setTitle("Error");
        setPreferredSize(new Dimension(200, 100));
        SwingProps.setStartWindowCenter(this, 200, 100);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void main(String[] args) {
        ErrorDialog dialog = new ErrorDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        headerTextF = new JLabel();
        descriptionTextF = new JLabel();
    }

    public void setErrorText(String errorText) {
        descriptionTextF.setText(errorText);
    }

    public void setErrorText(String headerText, String descriptionText) {
        headerTextF.setText(headerText);
        descriptionTextF.setText(descriptionText);
    }
}