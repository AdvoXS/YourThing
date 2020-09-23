package com.creation.core.utils.xml;

public class XMLProcessorFactory {
    public static <T> XMLProcessor getProcessor(Class<T> tClass){
        String className = tClass.getName();
        switch (className){
            case "XMLPropertyProcessor":
                return new XMLPropertyProcessor();
            default:
                return null;
        }
    }
}
