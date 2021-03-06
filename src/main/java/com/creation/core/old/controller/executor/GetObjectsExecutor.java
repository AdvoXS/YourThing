package com.creation.core.old.controller.executor;

import com.creation.core.old.controller.get.GetObjectController;

import java.util.List;
import java.util.logging.Logger;

public class GetObjectsExecutor extends RestExecutor {

    GetObjectController getController;

    Logger logger = Logger.getLogger(GetObjectsExecutor.class.getName());

    public <T> void createExecutor(Class<T> clazz) {
        try {
            if (context.getBean(clazz.getSimpleName()) instanceof GetObjectController)
                getController = (GetObjectController) context.getBean(clazz.getSimpleName());
            else
                throw new RuntimeException("Failed init " + this.getClass().getSimpleName() + " injected class " + clazz.getSimpleName() + " not valid");
            run();
        } catch (RuntimeException e) {
            logger.info(e.getMessage());
        }
    }

    @Override
    void run() {
        getController.setHttpGet();
        getController.configure();
        getController.getResponse();
        getController.read();
        getController.createObjects();
    }

    @Override
    void getResponseInfo() {

    }

    public List<Object> getObjectList() {
        return getController.getObjectList();
    }

}
