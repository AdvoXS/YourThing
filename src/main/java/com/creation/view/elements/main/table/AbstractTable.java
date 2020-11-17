package com.creation.view.elements.main.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;

@Component
public class AbstractTable extends JTable {
    @Autowired
    protected ApplicationContext con;

    public <T> void fillTable(ArrayList<T> list) {
    }

    public void refresh() {

    }
}
