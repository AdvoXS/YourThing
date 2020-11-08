package com.creation.core.utils.xml;

import org.xml.sax.helpers.DefaultHandler;

public abstract class XMLProcessor extends DefaultHandler {

    private String value;

    private String key;

    public String getValue() {
        return value;
    }

    protected void setValue(String value) { this.value = value; }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
