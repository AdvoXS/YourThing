package com.creation.view.elements.row.creators;

import com.creation.entity.Entity;
import com.creation.entity.Product;
import com.creation.view.elements.row.EntityName;
import com.creation.view.elements.row.RowItemPanel;
import com.creation.view.elements.row.RowProductPanel;

import java.util.logging.Logger;

import javax.swing.*;
import java.awt.*;

public class RowProductCreator implements RowItemCreator {

    RowItemPanel panel;
    GridBagConstraints constraints;
    Logger logger;

    @Override
    public RowItemPanel createItem(Entity entity) {
        logger = Logger.getLogger(RowProductCreator.class.getName());
        if (entity instanceof Product) {
            Product product = (Product) entity;
            panel = new RowProductPanel(product);
            constraints = new GridBagConstraints();
            configureLayout();
            createComponents(product);
        } else {
            logger.info("Not valid instance of injected object  " + entity.getClass().getName() + ". Valid is " + Product.class.getName());
        }
        return panel;

    }

    /**
     * pre-instance configuration layout
     */
    private void configureLayout() {
    }

    private void createComponents(Product product) {
        createLabelName(product.getTitle());
        createLabelDescr(product.getDescription().substring(0, 12) + "...");
    }

    private void createLabelName(String title) {
        JLabel productName = new JLabel(title);
        productName.setName(EntityName.PRODUCT_NAME);
        productName.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = 0;
        panel.addComponent(productName, constraints);
    }

    private void createLabelDescr(String description) {
        JLabel productDescription = new JLabel(description);
        productDescription.setName(EntityName.PRODUCT_SHORT_DESCRIPTION);
        productDescription.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 2;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.addComponent(productDescription, constraints);
    }
}
