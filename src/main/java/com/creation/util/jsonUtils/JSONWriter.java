package com.creation.util.jsonUtils;

import com.creation.core.utils.jsonUtils.JSONFile;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JSONWriter extends JSONFile {

    public JSONWriter(String fileName) {
        super(fileName);
    }

    /**
     * Запись в json массива в виде: "key":"value"
     *
     * @param params - словарь ключ-значение
     */
    public void addPairs(HashMap<String, Object> params) {
        obj.putAll(params);
    }

    /**
     * Запись в json массива в виде: "key":["value1","value2"]
     *
     * @param key  - ключ
     * @param list - список значений
     */
    public void addArray(String key, ArrayList list) {
        JSONArray jsonList = new JSONArray();
        jsonList.addAll(list);
        obj.put(key, jsonList);
    }

    /**
     * запись в файл по пути - vol/JSON/fileName.json
     */
    public void write() {
        try (FileWriter file = new FileWriter(fullFileName)) {
            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
