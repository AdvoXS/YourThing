package com.creation.view.elements.main.tablemodel;

import org.springframework.stereotype.Component;

@Component
public class UsersTableModel extends ItemTableModel {

    public UsersTableModel() {
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
