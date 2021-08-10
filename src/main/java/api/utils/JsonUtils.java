package api.utils;

import com.google.gson.Gson;


public class JsonUtils {
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static String queryStringtoJson(String string) {
        String json = "{\"";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '=') {
                json += "\"" + ":" + "\"";
            } else if (string.charAt(i) == '&') {
                json += "\"" + "," + "\"";
            } else {
                json += string.charAt(i);
            }
        }
        json += "\"" + "}";

        return json;
    }
}
