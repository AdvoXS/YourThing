package com.creation.view.elements.main.tablemodel;

import org.springframework.stereotype.Component;

import javax.swing.table.AbstractTableModel;

@Component
public abstract class ItemTableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 1;
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
