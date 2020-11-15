package com.creation.view.frames;

import com.creation.entity.User;
import com.creation.service.UserUpdateService;
import com.creation.view.core.SwingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

@Component
public class ProfileFrame extends JFrame {

    @Autowired
    UserUpdateService service;

    @Autowired
    SwingAction swingAction;

    User user;

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


    /*public void update() {
        if (isMyProfile) myProfile();
    }*/

    public void setUser(User user) {
        this.user = user;
        updateInfo();
    }

    /*private User getUser() {
        if (isMyProfile && auth != null) return auth.getUser();
        else if (!isMyProfile && otherUser != null) return otherUser;
        else throw new RuntimeException("Ошибка получения пользователя");
    }*/

    private void updateInfo() {
        textField1.setText(user.getFirst_name());
        textField2.setText(user.getLast_name());
        textField3.setText(user.getEmail());

        firstNameInfo.setText(user.getFirst_name());
        secondNameInfo.setText(user.getLast_name());
        emailInfo.setText(user.getEmail());
    }

    private void setsEditButton() {
        editButton = new JButton();
        editButton.addActionListener(e -> {
            if (!isEdit) {
                setEdit();
            } else {
                user = service.updateUser(user, getParams());
                setNotEdit();
            }
        });
    }


    private HashMap<String, String> getParams() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("name", textField1.getText());
        params.put("second_name", textField2.getText());
        params.put("email", textField3.getText());
        return params;
    }

    private void setEdit() {
        infoPanel1.setVisible(false);
        editPanel.setVisible(true);
        editButton.setText("Сохранить");
        editAvaPanel.setVisible(true);
        isEdit = true;
        updateInfo();
    }

    private void setNotEdit() {
        infoPanel1.setVisible(true);
        editPanel.setVisible(false);
        editButton.setText("Изменить");
        editAvaPanel.setVisible(false);
        isEdit = false;
        updateInfo();
    }

    private void setsCloseButton() {
        closeButton = new JButton();
        closeButton.addActionListener(e -> this.setVisible(false));
    }
}
