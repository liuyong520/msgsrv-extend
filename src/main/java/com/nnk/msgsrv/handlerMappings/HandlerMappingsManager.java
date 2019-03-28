package com.nnk.msgsrv.handlerMappings;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMappingsManager {
    private static HashMap<String, HashMap<Object, Method>> METHOD_HANDLER_MAPPING = new HashMap();

    public static int size() {
        return METHOD_HANDLER_MAPPING.size();
    }

    public static boolean isEmpty() {
        return METHOD_HANDLER_MAPPING.isEmpty();
    }

    public static HashMap<Object, Method> get(Object key) {
        return METHOD_HANDLER_MAPPING.get(key);
    }

    public static boolean containsKey(Object key) {
        return METHOD_HANDLER_MAPPING.containsKey(key);
    }

    public static HashMap<Object, Method> put(String key, HashMap<Object, Method> value) {
        if(containsKey(key)){
            throw new RuntimeException("MsgSrvCommand command’s name is duplicate");
        }
        return METHOD_HANDLER_MAPPING.put(key, value);
    }

    public static void putAll(Map<? extends String, ? extends HashMap<Object, Method>> maps) {
        for(Map.Entry<? extends String, ? extends HashMap<Object, Method>> entry :maps.entrySet()){
            if(containsKey(entry.getKey())){
                throw new RuntimeException("MsgSrvCommand command’s name is duplicate");
            }
            put(entry.getKey(),entry.getValue());
        }
    }
}
