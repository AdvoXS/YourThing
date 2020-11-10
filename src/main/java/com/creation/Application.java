package com.creation;


import com.alee.laf.WebLookAndFeel;
import com.creation.controller.spring.post.OperatorLoginSC;
import com.creation.core.config.SpringApplicationConfig;
import com.creation.core.controller.executor.GetObjectsExecutor;
import com.creation.core.controller.executor.PostExecutor;
import com.creation.view.frames.MainFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Application {

    static GetObjectsExecutor objectsExecutor;
    static PostExecutor postExecutor;
    static OperatorLoginSC opLoginController;
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        WebLookAndFeel.install(); // theme UI
        /*objectsExecutor = context.getBean(GetObjectsExecutor.class);
        objectsExecutor.createExecutor(MainController.class);
        objectsExecutor.getObjectList();
        postExecutor = context.getBean(PostExecutor.class);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User());
        postExecutor.setPostData(Collections.singletonList(users));
        postExecutor.createExecutor(OperatorLoginC.class);
        postExecutor.run();
        postExecutor.getResponseInfo();*/
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
