package com.creation.core.old.controller.executor;

import com.creation.core.old.controller.service.PostService;

import java.util.List;
import java.util.logging.Logger;


public class PostExecutor extends RestExecutor {

    PostService service;

    List<Object> reqObjects = null;

    Logger logger = Logger.getLogger(GetObjectsExecutor.class.getName());

    public <T> void createExecutor(Class<T> clazz) {
        try {
            if (context.getBean(clazz.getSimpleName()) instanceof PostService)
                service = (PostService) context.getBean(clazz.getSimpleName());
            else
                throw new RuntimeException("Failed init " + this.getClass().getSimpleName() + " injected class " + clazz.getSimpleName() + " not valid");
            run();
        } catch (RuntimeException e) {
            logger.info(e.getMessage());
        }
    }

    public void setPostData(List<Object> reqObjects) {
        this.reqObjects = reqObjects;
    }

    @Override
    public void getResponseInfo() {
        System.out.println("Server output: " + service.getResponseInfo());
    }

    @Override
    public void run() {
        try {
            if (reqObjects == null || reqObjects.isEmpty()) {
                throw new RuntimeException("Before send post you need set data!");
            } else {
                service.setHttpPost();
                service.setRequest(reqObjects);
                service.setContentType();
                service.send();
                service.read();
                service.postProcess();
            }
        } catch (RuntimeException e) {
            logger.info(e.getMessage());
        }
    }

}
