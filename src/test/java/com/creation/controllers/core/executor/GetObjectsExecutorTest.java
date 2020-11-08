package com.creation.controllers.core.executor;

import com.creation.controllers.get.MainController;
import com.creation.core.config.SpringApplicationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class GetObjectsExecutorTest {
    ApplicationContext context;
    GetObjectsExecutor getObjectsExecutor;


    @Test
    public void createExecutor() {
        getObjectsExecutor.createExecutor(RestExecutor.class);
    }


    @Test
    public void getObjectList() {
        context = new AnnotationConfigApplicationContext(SpringApplicationConfig.class);
        getObjectsExecutor = context.getBean(GetObjectsExecutor.class);
        getObjectsExecutor.createExecutor(MainController.class);
        assert !getObjectsExecutor.getObjectList().isEmpty();
    }
}