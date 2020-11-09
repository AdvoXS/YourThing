package com.creation.controllers.core.executor;

import com.creation.controllers.core.post.SimplePostController;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PostExecutor extends RestExecutor {

    SimplePostController controller;
    Logger logger = Logger.getLogger(GetObjectsExecutor.class.getName());

    public <T> void createExecutor(Class<T> clazz) {
        try {
            if (context.getBean(clazz.getSimpleName()) instanceof SimplePostController)
                controller = (SimplePostController) context.getBean(clazz.getSimpleName());
            else
                throw new RuntimeException("Failed init " + this.getClass().getSimpleName() + " injected class " + clazz.getSimpleName() + " not valid");
            run();
        } catch (RuntimeException e) {
            logger.info(e.getMessage());
        }
    }

    @Override
    public void getResponseInfo() {
        System.out.println("Server output: " + controller.getResponseInfo());
    }

    @Override
    public void run() {
        controller.setHttpPost();
        controller.setRequest();
        controller.setContentType();
        controller.send();
        controller.read();
    }

}
