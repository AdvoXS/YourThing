package com.creation.view.frames;

import com.creation.view.core.SwingProps;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@Component
@Lazy
public class ErrorDialog extends JDialog {
    private JPanel contentPane;
    private JLabel descriptionTextF;
    private JLabel headerTextF;
    private JButton buttonCancel;

    public ErrorDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);
        setTitle("Error");
        setPreferredSize(new Dimension(500, 200));
        SwingProps.setStartWindowCenter(this, 200, 100);
        pack();
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
        descriptionTextF = new JLabel();
        headerTextF = new JLabel();
    }

    public void setErrorText(String errorText) {
        headerTextF.setText("Ошибка пользователя");
        descriptionTextF.setText(errorText);
    }

    public void setErrorText(String headerText, String descriptionText) {
        headerTextF.setText(headerText);
        descriptionTextF.setText(descriptionText);
    }
}
