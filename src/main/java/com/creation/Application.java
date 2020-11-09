package com.creation;


import com.alee.laf.WebLookAndFeel;
import com.creation.controllers.core.executor.GetObjectsExecutor;
import com.creation.controllers.core.executor.PostExecutor;
import com.creation.controllers.get.MainController;
import com.creation.controllers.post.OperatorLoginC;
import com.creation.controllers.post.UserSignUpC;
import com.creation.core.config.SpringApplicationConfig;
import com.creation.view.frames.MainFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Application {

    static GetObjectsExecutor objectsExecutor;
    static PostExecutor postExecutor;

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        WebLookAndFeel.install(); // theme UI
        objectsExecutor = context.getBean(GetObjectsExecutor.class);
        objectsExecutor.createExecutor(MainController.class);
        objectsExecutor.getObjectList();
        postExecutor = context.getBean(PostExecutor.class);
        postExecutor.createExecutor(UserSignUpC.class);
        postExecutor.run();
        postExecutor.getResponseInfo();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
