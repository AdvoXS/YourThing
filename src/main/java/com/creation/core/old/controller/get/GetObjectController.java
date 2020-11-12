package com.creation.core.old.controller.get;

import com.creation.core.old.controller.Controller;
import com.creation.core.old.controller.service.GetService;

import java.util.ArrayList;
import java.util.List;


public abstract class GetObjectController extends GetService implements Controller {

    protected List<Object> objectList = new ArrayList<>();

    public abstract void createObjects();

    public List<Object> getObjectList() {
        return objectList;
    }

}
