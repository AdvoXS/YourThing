package com.creation.core.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property extends Properties {
    public Property() {
        super();
        try {
            load(new FileReader("./src/main/resources/project_properties.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
