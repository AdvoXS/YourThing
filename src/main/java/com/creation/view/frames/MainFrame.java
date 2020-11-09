package com.creation.view.frames;

import com.creation.view.elements.HTextField;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton button1;
    boolean isFilterClicked = true;
    private JButton button3;
    private JPanel panel1;
    private JSplitPane splitPane1;
    private JPanel mainPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JButton filterBut;
    private JPanel searchPanel;
    private JLabel searchByLabel;
    private JComboBox<String> searchByBox;
    private JPanel filterPanel1;
    private JButton ApplyFilterProdButton;
    private JTextField CostFromTextF;
    private JPanel filterPanelProduct;
    private JTextField CostToTextF;
    private JPanel FullPanel;
    private JComboBox<String> CategoryProductBox;

    public MainFrame() {
        setTitle("Market Place");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        int sizeWidth = 800;
        int sizeHeight = 600;
        setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - sizeWidth) / 2, (screenSize.height - sizeHeight) / 2);
        pack();
    }

    private void createUIComponents() {
        splitPane1 = new JSplitPane();
        panel1 = new JPanel();
        button1 = new JButton("Hello");
        ApplyFilterProdButton = new JButton("Hi");
        button3 = new JButton("Buy");
        searchButton = new JButton();
        searchField = new HTextField("Поиск...");
        filterBut = new JButton();
        searchPanel = new JPanel();


        filterPanel1 = new JPanel();
        searchByLabel = new JLabel("Поиск по");
        searchByBox = new JComboBox<String>();
        searchByBox.addItem("По товарам");
        searchByBox.addItem("По магазинам");

        filterPanelProduct = new JPanel();
        CostFromTextF = new HTextField("Стоимость от");
        CostToTextF = new HTextField("Стоимость до");

        CategoryProductBox = new JComboBox<String>();
        CategoryProductBox.addItem("Верхняя одежда");
        CategoryProductBox.addItem("Штаны");
        CategoryProductBox.addItem("Шорты");
        CategoryProductBox.addItem("Футболки");
        CategoryProductBox.addItem("Украшения");

        filterBut.setBackground(Color.WHITE);
        filterBut.addActionListener((e) -> {
            if (isFilterClicked) {
                filterPanel1.setVisible(false);
                filterPanelProduct.setVisible(false);
                isFilterClicked = false;
            } else {
                filterPanel1.setVisible(true);
                filterPanelProduct.setVisible(true);
                isFilterClicked = true;
            }

        });
        /*
        Product product = new Product();
        product.setTitle("Car");
        product.setDescription("description of this product");
        searchPanel.add(new RowProductCreator().createItem(product));*/
    }
}
