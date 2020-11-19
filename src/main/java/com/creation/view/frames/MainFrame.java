package com.creation.view.frames;

import com.creation.entity.Auth;
import com.creation.entity.User;
import com.creation.service.DeleteUserService;
import com.creation.service.UserListService;
import com.creation.view.core.SwingAction;
import com.creation.view.core.SwingProps;
import com.creation.view.elements.HTextField;
import com.creation.view.elements.main.table.AbstractTable;
import com.creation.view.elements.main.table.UsersTable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.Objects;

@Component
@Lazy
public class MainFrame extends JFrame {
    final
    ApplicationContext con;
    final
    SwingAction swingAction;
    boolean isFilterClicked = true;
    private JButton button3;
    private JPanel panel1;
    private JSplitPane splitPane1;
    private JPanel mainPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton filterBut;
    private JPanel searchPanel;
    private JLabel searchByLabel;
    private JComboBox<String> searchByBox;
    private JPanel filterPanel1;
    private JButton ApplyFilterProdButton;
    private JTextField CostFromTextF;
    private JPanel filterPanelProduct;
    private JTextField CostToTextF;
    private JPanel FullPanel;
    private JComboBox<String> CategoryProductBox;

    int sizeWidth = 800;
    int sizeHeight = 600;
    private JButton profileButton;
    private JButton marketButton;
    private final String SEARCH_BY_PROFILES = "По профилям";
    private final String SEARCH_BY_SHOP = "По магазинам";
    private final String SEARCH_BY_GOODS = "По товарам";
    private AbstractTable viewTable;
    private JScrollPane scrollPaneT;
    private JPanel filterUserPanel;
    private JTextField filterUserField;
    private JButton filterUserApplyBut;
    private JLabel filterUserNameLabel;
    private JPanel controlPanel;
    private JButton controlAddButton;
    private JTextField filterUserSNameField;
    private JTextField filterUserMailField;
    private JButton deleteButton;
    private JPanel deprecatePanel;

    public MainFrame(ApplicationContext con, SwingAction swingAction) {
        setTitle("Market Place");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        SwingProps.setStartWindowCenter(this, sizeWidth, sizeHeight);
        pack();
        this.con = con;
        this.swingAction = swingAction;
        afterInit();
    }

    private void afterInit() {
        if (con.getBean(Auth.class).isOperator()) {
            Auth gauth = con.getBean(Auth.class);
            searchByBox.addItem("По профилям");
        }
    }

    private void createUIComponents() {

        profileButton = new JButton("Hello");
        ApplyFilterProdButton = new JButton("Hi");
        button3 = new JButton("Buy");
        searchButton = new JButton();
        searchField = new HTextField("Поиск...");
        filterBut = new JButton();
        searchPanel = new JPanel();

        marketButton = new JButton();
        filterPanel1 = new JPanel();
        searchByLabel = new JLabel("Поиск по");
        searchByBox = new JComboBox<String>();
        searchByBox.addItem("По товарам");
        searchByBox.addItem("По магазинам");

        deprecatePanel = new JPanel();
        deprecatePanel.setVisible(false);

        filterPanelProduct = new JPanel();
        CostFromTextF = new HTextField("Стоимость от");
        CostToTextF = new HTextField("Стоимость до");

        CategoryProductBox = new JComboBox<String>();

        filterBut.setBackground(Color.WHITE);
        filterBut.addActionListener((e) -> {
            if (isFilterClicked) {
                filterPanel1.setVisible(false);
                filterPanelProduct.setVisible(false);
                isFilterClicked = false;
            } else {
                filterPanel1.setVisible(true);
                filterPanelProduct.setVisible(true);
                isFilterClicked = true;
            }

        });

        profileButton.addActionListener(e -> {
            ProfileFrame profile = con.getBean(ProfileFrame.class);
            profile.setUser(con.getBean(Auth.class).getUser());
            profile.setVisible(true);
        });


        scrollPaneT = new JScrollPane();
        viewTable = new AbstractTable();
        setControlPanel();
        setFilterUserPanel();
        searchByBox.addActionListener(e -> {
            switch (searchByBox.getSelectedItem().toString()) {
                case SEARCH_BY_PROFILES:
                    showUserPanel();
                    break;
                case SEARCH_BY_GOODS:
                    filterPanelProduct.setVisible(true);
                    filterUserPanel.setVisible(false);
                    break;
            }
        });
    }

    private void setControlPanel() {
        controlPanel = new JPanel();
        controlAddButton = new JButton();
        deleteButton = new JButton();
        deleteButton.addActionListener(e -> {
            if (viewTable.getSelectedRow() != -1) {
                int id = (int) viewTable.getValueAt(viewTable.getSelectedRow(), 0);
                User user = con.getBean(UserListService.class).getUserById(id);
                if (JOptionPane.showConfirmDialog(this, "Вы действительно хотите удалить пользователя с email " + user.getEmail() + " ?") == 0) {
                    con.getBean(DeleteUserService.class).delete(user);
                }
            } else {
                swingAction.displayError("Выделите строку с пользователем, которого хотите удалить");
            }
        });
    }

    private void showUserPanel() {
        filterPanelProduct.setVisible(false);
        filterUserPanel.setVisible(true);
    }

    private void setFilterUserPanel() {
        filterUserPanel = new JPanel();
        filterUserPanel.setVisible(false);
        filterUserApplyBut = new JButton();
        filterUserApplyBut.addActionListener(e -> {
            if (Objects.equals(searchByBox.getSelectedItem(), "По профилям")) {
                viewUsersTable();
            }
        });
        filterUserField = new HTextField("");
        setFilterTextField(filterUserField);
        filterUserField.setName("filterUserField");
        filterUserSNameField = new JTextField();
        setFilterTextField(filterUserSNameField);
        filterUserSNameField.setName("filterUserSNameField");
        filterUserMailField = new JTextField();
        setFilterTextField(filterUserMailField);
        filterUserMailField.setName("filterUserMailField");
    }

    private void setFilterTextField(JTextField filterField) {
        filterField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                doIt();
            }

            public void removeUpdate(DocumentEvent e) {
                doIt();
            }

            public void insertUpdate(DocumentEvent e) {
                doIt();
            }

            private void doIt() {
                if (StringUtils.isEmpty(filterField.getText())) viewUsersTable();
                else {
                    UserListService service = con.getBean(UserListService.class);
                    viewTable.fillTable(service.filterUser(filterUserField.getText(), filterUserSNameField.getText(), filterUserMailField.getText()));
                    scrollPaneT.setViewportView(viewTable);
                }
                filterField.revalidate();
            }
        });
    }

    public void viewUsersTable() {
        viewTable = con.getBean(UsersTable.class);
        UserListService service = con.getBean(UserListService.class);
        viewTable.fillTable(service.getAllUsers());
        scrollPaneT.setViewportView(viewTable);
    }
}
