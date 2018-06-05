package ba.unsa.etf.nwtcinemaauth.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONConverter {

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void configure() {
        JsonFactory factory = new JsonFactory();
        factory.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        OBJECT_MAPPER = new ObjectMapper(factory);
    }

    public static String toJSON(Object source) {
        try {
            return OBJECT_MAPPER.writeValueAsString(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJSON(InputStream json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
