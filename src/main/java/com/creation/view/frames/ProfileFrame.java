package com.creation.view.frames;

import com.creation.entity.User;
import com.creation.restobject.auth.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ProfileFrame extends JFrame {
    @Autowired
    Auth auth;
    private boolean isEdit = false;
    private boolean isMyProfile = true;
    private JButton closeButton;

    private JPanel ProfilePanel;
    private JButton editButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel infoPanel;
    private JLabel avatarPicture;
    private JPanel editPanel;
    private JLabel firstNameInfo;
    private JLabel secondNameInfo;
    private JLabel emailInfo;
    private JPanel infoPanel1;
    private JLabel nameEditF;
    private JLabel sNameEsitF;
    private JLabel emailEditF;
    private JButton editAvaButton;
    private JPanel editAvaPanel;

    public ProfileFrame() {
        setTitle("Your Things");
        setContentPane(ProfilePanel);
        setPreferredSize(new Dimension(600, 500));
        pack();
    }

    private void createUIComponents() {
        setsCloseButton();
        setsEditButton();
        //edit panel
        editPanel = new JPanel();
        editPanel.setVisible(false);
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        editAvaPanel = new JPanel();
        editAvaPanel.setVisible(false);
        //infoPanel
        infoPanel1 = new JPanel();
        firstNameInfo = new JLabel();
        secondNameInfo = new JLabel();
        emailInfo = new JLabel();
        // TODO: place custom component creation code here
    }

    public void update() {
        if (isMyProfile) myProfile();
    }

    public void myProfile() {
        isMyProfile = true;
        updateInfo(auth.getUser());
    }

    private void updateInfo(User user) {
        textField1.setText(user.getFirstName());
        textField2.setText(user.getLastName());
        textField3.setText(user.getEmail());

        firstNameInfo.setText(user.getFirstName());
        secondNameInfo.setText(user.getLastName());
        emailInfo.setText(user.getEmail());
    }

    private void setsEditButton() {
        editButton = new JButton();
        editButton.addActionListener(e -> {
            if (!isEdit) {
                infoPanel1.setVisible(false);
                editPanel.setVisible(true);
                editButton.setText("Сохранить");
                editAvaPanel.setVisible(true);
                isEdit = true;
            } else {
                infoPanel1.setVisible(true);
                editPanel.setVisible(false);
                editButton.setText("Изменить");
                editAvaPanel.setVisible(false);
                isEdit = false;
            }
        });
    }

    private void setsCloseButton() {
        closeButton = new JButton();
        closeButton.addActionListener(e -> this.setVisible(false));
    }
}
