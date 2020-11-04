package com.creation;


import com.alee.laf.WebLookAndFeel;
import com.creation.view.frames.LoginFrame;
import com.creation.view.frames.MainFrame;


public class Application  {
    public static void main(String [] args){
        WebLookAndFeel.install(); // theme UI
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        //точка входа в Application
    }
}
