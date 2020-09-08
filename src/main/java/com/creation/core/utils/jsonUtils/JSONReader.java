package com.creation.core.utils.jsonUtils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Core class
 * Класс предназначен для считывания данных из JSON файла
 */
public class JSONReader extends JSONFile {

    protected JSONReader(String fileName) {
        super(fileName);
    }

    /**
     * Чтение входящего JSON
     */
    protected void read() {
        StringBuilder jsonStrBuilder = readFile();
        obj = writeJSONObject(jsonStrBuilder);
    }


    /**
     * Читает из файла данные
     *
     * @return строковое представление данных
     */
    private StringBuilder readFile() {
        StringBuilder jsonStrBuilder = new StringBuilder();
        Scanner inputScanner;
        try {
            inputScanner = new Scanner(new File(fullFileName));
            while (inputScanner.hasNext()) // Цикл чтения из файла
                jsonStrBuilder.append(inputScanner.next());
            inputScanner.close();
        } catch (
                FileNotFoundException e) {
            System.err.println(e.toString());
        }
        return jsonStrBuilder;
    }

    /**
     * @param jsonStrBuilder строковое представление данных
     * @return представление JSON данных в виде JSONObject
     */
    private JSONObject writeJSONObject(StringBuilder jsonStrBuilder) {
        JSONParser jsonParser = new JSONParser();
        JSONObject resultJson = null; // Объект со всеми данными из JSON файла
        try {
            resultJson = (JSONObject) jsonParser.parse(jsonStrBuilder.toString());
        } catch (
                ParseException e) {
            System.err.println(e.toString());
        }
        return resultJson;
    }
}
