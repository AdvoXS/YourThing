package com.creation;


import com.creation.core.application.app.SpringApplicationConfig;
import com.creation.view.frames.LoginFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        LoginFrame loginFrame = context.getBean(LoginFrame.class);
        loginFrame.setVisible(true);
    }
}
