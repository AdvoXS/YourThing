package com.creation.view.frames;

import com.creation.entity.Product;
import com.creation.view.elements.HTextField;
import com.creation.view.elements.row.RowProductPanel;
import com.creation.view.elements.row.creators.RowProductCreator;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel1;
    private JSplitPane splitPane1;
    private JPanel mainPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton filterBut;
    private JPanel searchPanel;
    private JLabel searchByLabel;
    private JComboBox searchByBox;
    private JPanel filterPanel1;

    public MainFrame(){
        setTitle("Market Place");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

    private void createUIComponents() {
        splitPane1 = new JSplitPane();
        panel1 = new JPanel();
        button1 = new JButton("Hello");
        button2 = new JButton("Hi");
        button3 = new JButton("Buy");
        searchButton = new JButton();
        searchField = new HTextField("Поиск...");
        filterBut = new JButton();
        searchPanel = new JPanel();
        filterPanel1 = new JPanel();
        searchByLabel = new JLabel("Поиск по");
        searchByBox = new JComboBox();
        searchByBox.addItem("По товарам");
        searchByBox.addItem("По магазинам");
        /*
        Product product = new Product();
        product.setTitle("Car");
        product.setDescription("description of this product");
        searchPanel.add(new RowProductCreator().createItem(product));*/
    }
}
