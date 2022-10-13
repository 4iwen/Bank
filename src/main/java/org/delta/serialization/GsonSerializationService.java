package org.delta.serialization;

import com.google.gson.Gson;

import javax.inject.Singleton;

@Singleton
public class GsonSerializationService {

    private Gson gson = new Gson();

    public String serialize(Object object) {
        return gson.toJson(object);
    }

    public <T> T deserialize(String json, Class<T> type) {
        return this.gson.fromJson(json, type);
    }
}
