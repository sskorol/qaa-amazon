package io.github.sskorol.data;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import lombok.val;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Class for reading data from json files.
 */
public class JsonReader implements DataReader {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] readFrom(final String dataSource, final Class<T> entityClass) {
        final val gson = new Gson();
        try (val fileReader = new InputStreamReader(new FileInputStream(getSystemResource(dataSource).getPath()),
                "UTF-8");
             val reader = new com.google.gson.stream.JsonReader(fileReader)) {
            final val json = new JsonParser().parse(reader);
            return json.isJsonArray() ? gson.fromJson(json, castToArray(entityClass))
                    : (T[]) new Object[]{gson.fromJson(json, castToObject(entityClass))};
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read " + dataSource, e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T[]> castToArray(final Class<T> entityClass) {
        return (Class<T[]>) (entityClass.isArray() ? entityClass : Array.newInstance(entityClass, 1).getClass());
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T> castToObject(final Class<T> entityClass) {
        return (Class<T>) (entityClass.isArray() ? entityClass.getComponentType() : entityClass);
    }

    @Override
    public String dataType() {
        return "json";
    }
}
