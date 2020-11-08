package com.creation.view.elements.main.tablemodel;

import com.creation.entity.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public abstract class ItemTableModel extends AbstractTableModel {

    @Autowired
    List<Entity> items;

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

    public void setItemList(List<Entity> itemList) {
        this.items = itemList;
    }

}
