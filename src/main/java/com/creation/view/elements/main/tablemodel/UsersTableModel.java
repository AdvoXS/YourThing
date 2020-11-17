package com.creation.view.elements.main.tablemodel;

import com.creation.entity.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
@Lazy
public class UsersTableModel extends ItemTableModel {

    protected String[] columnsHeader = {"Id", "Имя", "Фамилия", "Email", "Создан", "Изменен"};

    private ArrayList<User> userList;

    public UsersTableModel() {
        userList = new ArrayList<>();
    }

    public User get(int i) {
        return userList.get(i);
    }

    public void clear() {
        userList = new ArrayList<>();
    }

    public void fillAllUsers(ArrayList<User> list) {
        userList = list;
    }

    public void addUsers(ArrayList<User> list) {
        userList.addAll(list);
    }

    public void addUser(User user) {
        userList.add(user);
        fireTableRowsInserted(userList.size() - 1, userList.size() - 1);
    }

    public void removeUser(int row) {
        userList.remove(row);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }

    @Override
    public int getColumnCount() {
        return columnsHeader.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        switch (col) {
            case 0:
                temp = userList.get(row).getId();
                break;
            case 1:
                temp = userList.get(row).getFirst_name();
                break;
            case 2:
                temp = userList.get(row).getLast_name();
                break;
            case 3:
                temp = userList.get(row).getEmail();
                break;
            case 4:
                temp = userList.get(row).getCreated_at();
                break;
            case 5:
                temp = userList.get(row).getUpdated_at();
                break;
        }
        return temp;
    }

    @Override
    public int getRowCount() {
        return userList.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return columnsHeader[column];
    }

    public Class getColumnClass(int col) {
        switch (col) {
            case 0:
                return int.class;
            case 4:
                return Date.class;
            case 5:
                return Date.class;
            default:
                return String.class;

        }
    }


}
