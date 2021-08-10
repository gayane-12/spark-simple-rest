package api.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static api.utils.JsonUtils.toJson;

public class FileUtils {
    @SneakyThrows(IOException.class)
    public static <T> void writeList(String path, List<T> data) {
        Writer writer = Files.newBufferedWriter(Paths.get(path));
        writer.write(toJson(data));
        writer.close();
    }

    @SneakyThrows(IOException.class)
    public static <T> List<T> readList(String path, Type type) {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        List<T> data = new Gson().fromJson(reader, type);
        reader.close();

        return data;
    }
}
