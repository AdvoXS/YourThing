package com.creation.core.application;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class App {

    private static Map<String, String> stringCache = Collections.synchronizedMap(new WeakHashMap<String, String>());

    private static Map<String, Object> objectCache = Collections.synchronizedMap(new WeakHashMap<String, Object>());

    public static Map<String, String> getStringCache() {
        return stringCache;
    }

    public static Map<String, Object> getObjectCache() {
        return objectCache;
    }


}
