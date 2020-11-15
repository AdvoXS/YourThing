package com.creation.view.elements.main.table;

import com.creation.controller.spring.get.UserListSC;
import com.creation.entity.User;
import com.creation.view.core.SwingAction;
import com.creation.view.elements.main.tablemodel.UsersTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class UsersTable extends AbstractTable {
    @Autowired
    UsersTableModel tableModel;

    @Autowired
    UserListSC controller;

    private Object[] columnsHeader = new String[]{"Id", "Имя", "Фамилия", "Email", "Создан", "Изменен"};

    public UsersTable() {
        tableModel.setColumnIdentifiers(columnsHeader);
        fillTable();
        setModel(tableModel);
    }

    public void fillTable() {
        List<User> userList = controller.getList().getUserList();
        if (!userList.isEmpty()) {
            tableModel.setRowCount(0);
            for (User user : userList) {
                tableModel.addRow(new Object[]{user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCreated_at(), user.getUpdated_at()});
            }
        } else {
            SwingAction ed = con.getBean(SwingAction.class);
            ed.displayError("Системная ошибка", "Ошибка получения пользователей");
        }
    }

    @Override
    public void refresh() {
        fillTable();
    }
}
