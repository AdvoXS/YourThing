package com.creation.core.utils;


import com.creation.core.utils.xml.XMLProcessor;
import com.creation.core.utils.xml.XMLProcessorFactory;
import com.creation.core.utils.xml.XMLPropertyProcessor;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * @Author Borisov Ivan
 * @Date 07.09.2020
 */

public class AppProperty {
    private static final String propertyURL = "./src/main/resources/project_properties.xml";
    private static final SAXParserFactory factory = SAXParserFactory.newInstance();
    private static XMLProcessor processor;
    private static SAXParser parser;

    /**
     * Получение настройки проекта по пути /src/main/resources/project_properties.xml
     */
    public static Object getProperty(String property) {
        try {
            parse(property);
            if (processor.getValue() != null)
                return processor.getValue();
        } catch (Exception ignored) {

        }
        return new Object();
    }

    private static void createParser() {
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void createProcessor(String property) {
        processor = XMLProcessorFactory.getProcessor(XMLPropertyProcessor.class);
        if (processor != null)
            processor.setKey(property);
    }

    private static void parse(String property) {
        createParser();
        createProcessor(property);
        try {
            parser.parse(new File(propertyURL), processor);
        } catch (IOException | SAXException e) {

        }
    }
}
