package com.creation.view.elements.main.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

public abstract class AbstractTable extends JTable {
    @Autowired
    protected ApplicationContext con;

    public void refresh() {

    }
}
