package com.creation.view.elements.main.table;

import com.creation.entity.User;
import com.creation.view.elements.main.tablemodel.UsersTableModel;
import com.creation.view.frames.ProfileFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

@Component
@Lazy
public class UsersTable extends AbstractTable {
    final
    UsersTableModel tableModel;

    @Autowired
    ProfileFrame profileFrame;

    public UsersTable(UsersTableModel tableModel) {
        this.tableModel = tableModel;
        RowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        setRowSorter(sorter);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    User user = tableModel.get(getSelectedRow());
                    HashMap<String, Object> params = new HashMap<>();
                    params.put("User", user);
                    showProfile(params);
                }
            }
        });
    }

    @Override
    public <T> void fillTable(ArrayList<T> userList) {
        if (!userList.isEmpty() && userList.get(0) instanceof User) {
            tableModel.clear();
            for (T t : userList) {
                User user = (User) t;
                tableModel.addUser(user);
            }
            setModel(tableModel);
        } else {
            tableModel.clear();
        }
    }

    private void showProfile(HashMap<String, Object> params) {
        profileFrame.visible(true, params);
    }

    @Override
    public void refresh() {
    }
}
