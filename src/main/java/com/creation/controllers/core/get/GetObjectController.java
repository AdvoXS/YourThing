package com.creation.controllers.core.get;

import com.creation.controllers.core.Controller;

import java.util.ArrayList;
import java.util.List;


public abstract class GetObjectController extends GetService implements Controller {

    protected List<Object> objectList = new ArrayList<>();

    public abstract void createObjects();

    public List<Object> getObjectList() {
        return objectList;
    }

}
