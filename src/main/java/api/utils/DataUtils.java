package api.utils;

import api.models.User;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class DataUtils {
    @SneakyThrows(IllegalAccessException.class)
    public static <T> T mergeObjects(T obj1, T obj2, T newObj) {
        Field[] fields = newObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj1Value = field.get(obj1);
            Object obj2Value = field.get(obj2);
            if (obj2Value != null && obj2Value != Integer.valueOf(0) && !obj2Value.equals(obj1Value)) {
                field.set(newObj, obj2Value);
            } else {
                field.set(newObj, obj1Value);
            }
        }
        return newObj;
    }

}
