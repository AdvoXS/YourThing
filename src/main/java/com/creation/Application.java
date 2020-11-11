package com.creation;


import com.alee.laf.WebLookAndFeel;
import com.creation.core.application.SpringApplicationConfig;
import com.creation.view.frames.LoginFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        /*WebLookAndFeel webLookAndFeel = new WebLookAndFeel();
        webLookAndFeel.initialize();*/
        WebLookAndFeel.install(); // theme UI
        LoginFrame loginFrame = context.getBean(LoginFrame.class);
        loginFrame.setVisible(true);
    }
}
