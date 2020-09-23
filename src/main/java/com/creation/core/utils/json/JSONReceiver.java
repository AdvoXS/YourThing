package com.creation.core.utils.json;

import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author Borisov Ivan
 * @Date 07.09.2020
 */
public class JSONReceiver extends JSONReader {
    public JSONReceiver(String fileName) {
        super(fileName);
        read();
    }

    /**
     * Получение данных ключ-значение ("key":"value")
     */
    public HashMap<String, Object> getPair(ArrayList<String> params) {
        HashMap<String, Object> result = new HashMap<>(params.size());
        for (String param : params)
            result.put(param, obj.get(param));
        return result;
    }

    /**
     * Получение данных в виде: "key":["value1","value2"]
     */
    public HashMap<String, ArrayList> getArray(ArrayList<String> params) {
        HashMap<String, ArrayList> result = new HashMap<>(params.size());
        for (String param : params) {
            JSONArray msg = (JSONArray) obj.get(param);
            Iterator<String> iterator = msg.iterator();
            ArrayList list = new ArrayList();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            result.put(param, list);
        }
        return result;
    }
}
