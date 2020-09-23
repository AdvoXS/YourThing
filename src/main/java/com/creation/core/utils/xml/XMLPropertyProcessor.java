package com.creation.core.utils.xml;

import org.xml.sax.Attributes;

public class XMLPropertyProcessor extends XMLProcessor {

    private String findProperty;

    private boolean get(String property) {
        return this.getKey().equals(property);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        findProperty = attributes.getValue("key");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (get(findProperty))
            setValue(new String(ch, start, length));
    }
}
