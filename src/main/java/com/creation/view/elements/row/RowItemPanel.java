package com.creation.view.elements.row;

import com.creation.entity.Entity;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public abstract class RowItemPanel extends JPanel {

    GridBagLayout layout;
    HashMap<String, JComponent> components;

    protected RowItemPanel(Entity entity) {
        layout = new GridBagLayout();
        setLayout(layout);
        components = new HashMap<>();
    }

    public void addComponent(JComponent component, GridBagConstraints constraints) {
        components.put(component.getName(), component);
        add(component, constraints);
    }

    public void removeComponent(JComponent component){
        components.remove(component);
        remove(component);
    }

    public void getComponent(EntityName name){
        components.get(name);
    }

    public GridBagLayout getLayout(){
        return layout;
    }
}
