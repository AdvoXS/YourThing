package com.creation.core.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class PropertyXMLProcessor {
    private static final String propertyURL = "./src/main/resources/project_properties.xml";
    private static final SAXParserFactory factory = SAXParserFactory.newInstance();
    private static XMLHandler handler;
    private static SAXParser parser;

    static {
        try {
            parser = factory.newSAXParser();
<<<<<<< HEAD
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
=======
        } catch (ParserConfigurationException | SAXException e) {
>>>>>>> 28199a0... #2 rework
            e.printStackTrace();
        }
    }


    /**
     * Получение настройки проекта по пути /src/main/resources/project_properties.xml
     */
    public static String getProperty(String property) {
        try {
            createParser(property);
            if (handler.getValue() != null)
                return handler.getValue();
        } catch (Exception ignored) {

        }
<<<<<<< HEAD
        return "";
=======
        return new String();
>>>>>>> 28199a0... #2 rework

    }

    /**
     * Получение настройки проекта по пути /src/main/resources/project_properties.xml
     */
    public static Boolean getProperty(Boolean property) {
        try {
            createParser(property.toString());
            if (handler.getValue() != null)
                return Boolean.parseBoolean(handler.getValue());
        } catch (Exception ignored) {

        }
        return false;
    }

    private static void createParser(String property) throws IOException, SAXException {
        handler = new XMLHandler();
        handler.setProperty(property);
        parser.parse(new File(propertyURL), handler);
    }

    private static class XMLHandler extends DefaultHandler {
        private String property;
        private String value;
        private String findProperty;

        public void setProperty(String property) {
            this.property = property;
        }

        private boolean get(String property) {
            return this.property.equals(property);
        }

        public String getValue() {
            return value;
        }

        @Override
<<<<<<< HEAD
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
=======
        public void startElement(String uri, String localName, String qName, Attributes attributes){
>>>>>>> 28199a0... #2 rework
            findProperty = attributes.getValue("key");
        }

        @Override
<<<<<<< HEAD
        public void characters(char[] ch, int start, int length) {
=======
        public void characters(char[] ch, int start, int length){
>>>>>>> 28199a0... #2 rework
            if (get(findProperty))
                value = new String(ch, start, length);
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) {

        }
    }
}
