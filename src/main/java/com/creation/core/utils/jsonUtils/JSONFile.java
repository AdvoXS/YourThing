package com.creation.core.utils.jsonUtils;

import org.json.simple.JSONObject;

public class JSONFile {

    protected final String fullFileName;
    protected JSONObject obj;

    protected JSONFile(String fileName) {
        this.fullFileName = JSONParams.PATH + fileName + JSONParams.POSTFIX;
        this.obj = new JSONObject();
    }
}
