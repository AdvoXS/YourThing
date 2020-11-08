package com.creation.core.utils.xml;

public class XMLProcessorFactory {
    public static <T> XMLProcessor getProcessor(Class<T> tClass) {
        String className = tClass.getName();
        if (className.equals(XMLPropertyProcessor.class.getName()))
            return new XMLPropertyProcessor();
        else return null;
    }
}
