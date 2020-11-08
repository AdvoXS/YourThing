package com.creation.core.utils;


import com.creation.core.utils.xml.XMLProcessor;
import com.creation.core.utils.xml.XMLProcessorFactory;
import com.creation.core.utils.xml.XMLPropertyProcessor;
import org.springframework.stereotype.Component;
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

@Component
public class AppProperty {
    private static final String propertyURL = "./src/main/resources/project_properties.xml";
    private static final SAXParserFactory factory = SAXParserFactory.newInstance();
    private static final XMLProcessor processor = XMLProcessorFactory.getProcessor(XMLPropertyProcessor.class);
    private static SAXParser parser;

    /**
     * Получение настройки проекта по пути /src/main/resources/project_properties.xml
     */
    public static String getProperty(String property) {
        try {
            parse(property);
            if (processor.getValue() != null)
                return processor.getValue();
        } catch (Exception ignored) {

        }
        return new String();
    }

    private static void createParser() {
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parse(String property) {
        createParser();
        processor.setKey(property);
        try {
            parser.parse(new File(propertyURL), processor);
        } catch (IOException | SAXException e) {

        }
    }
}
