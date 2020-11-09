package com.creation.view.frames;

import javax.swing.*;
import java.awt.*;

public class ProfileFrame extends JFrame {
    public ProfileFrame(){
        setTitle("Your Things");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(ProfilePanel);
        setPreferredSize(new Dimension(600, 500));
        pack();
    }

    private JPanel ProfilePanel;
}
