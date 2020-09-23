package com.creation.core.utils.json;

import com.creation.core.utils.AppProperty;

/**
 * Core class
 * Содержит константы, необходимые для обработки JSON
 */
public class JSONParams {

    public static final String POSTFIX = ".json";

    public static final String PATH = AppProperty.getProperty("path.json.files").toString();

}
