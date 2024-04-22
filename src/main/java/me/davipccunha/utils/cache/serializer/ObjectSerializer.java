package me.davipccunha.utils.cache.serializer;

import com.google.gson.Gson;

public class ObjectSerializer {
    private final static Gson gson = new Gson();

    public static <T> String serialize(T object) {
        return gson.toJson(object);
    }

    public static <T> T deserialize(String serialized, Class<T> clazz) {
        return gson.fromJson(serialized, clazz);
    }
}
