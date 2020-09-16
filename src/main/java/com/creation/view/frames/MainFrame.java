package com.creation.view.frames;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel1;
    private JSplitPane splitPane1;
    private JPanel mainPanel;

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
        // TODO: place custom component creation code here
    }
}
