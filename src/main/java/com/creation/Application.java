package com.creation;


import com.alee.laf.WebLookAndFeel;
import com.creation.view.frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Application  {
    public static void main(String [] args){
        WebLookAndFeel.install(); // theme UI
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        //точка входа в Application
    }
}
