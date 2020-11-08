package com.creation.controllers.core.get;

import java.util.ArrayList;
import java.util.List;


public abstract class GetObjectController extends GetService {

    protected List<Object> objectList = new ArrayList<>();

    public abstract void createObjects();

    public List<Object> getObjectList() {
        return objectList;
    }

}
