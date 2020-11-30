package com.creation.view.frames;

import com.creation.core.application.UserException;
import com.creation.entity.User;
import com.creation.service.admin.UserBecomeSellerService;
import com.creation.service.user.UserUpdateService;
import com.creation.view.core.SwingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

@Component
@Lazy
public class ProfileFrame extends AbstractFrame {

    @Autowired
    UserUpdateService service;

    @Autowired
    SwingAction swingAction;

    User user;

    private boolean isEdit = false;
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
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextArea textArea1;
    private JButton becomeSellerButton;

    public ProfileFrame() {
        setTitle("Your Things");
        setContentPane(ProfilePanel);
        setPreferredSize(new Dimension(600, 800));
        pack();
    }

    static {

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

        setBecomeSellerButton();

        // TODO: place custom component creation code here
    }

    public void setUser(User user) {
        this.user = user;
        updateInfo();
    }


    private void setBecomeSellerButton() {
        String mes = "Вы действительно хотите стать продавцом?\nАвтоматически отправится заявка на одобрение.";
        becomeSellerButton = new JButton();
        becomeSellerButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, mes) == 0) {
                if (con.getBean(UserBecomeSellerService.class).become()) {
                    JOptionPane.showMessageDialog(this, "Заявка успешно отправлена", "Информация", JOptionPane.INFORMATION_MESSAGE);
                    becomeSellerButton.setVisible(false);
                    setNotEdit();
                } else throw new UserException("Не удалось отправить заявку. Обратитесь к разработчику");
            }
        });
    }

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

    @Override
    public void visible(boolean isVisible, HashMap<String, Object> params) {
        super.visible(isVisible, params);
        user = (User) params.get("User");
        updateInfo();
        setNotEdit();
    }

    @Override
    public void visible(boolean isVisible, Object obj) {
        super.visible(isVisible, obj);
        user = (User) obj;
        updateInfo();
        setNotEdit();
    }
}
