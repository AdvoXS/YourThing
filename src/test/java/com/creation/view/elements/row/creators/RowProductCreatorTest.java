package com.creation.view.elements.row.creators;

import com.creation.entity.Message;
import com.creation.entity.Product;
import com.creation.view.elements.row.RowItemPanel;
import com.creation.view.elements.row.RowProductPanel;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;

public class RowProductCreatorTest {
    RowProductCreator  rowProductCreator;

    @Before
    public void init(){
        rowProductCreator = new RowProductCreator();
    }

    @Test
    public void whenInjectedProductIsEmpty() {
        RowItemPanel item = rowProductCreator.createItem(new Product());
        item.addComponent(new JLabel(),new GridBagConstraints());
    }
}