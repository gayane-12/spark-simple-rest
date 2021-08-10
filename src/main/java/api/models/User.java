package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    public static String RESOURCE_DIR = System.getProperty("user.dir") + "\\src\\main\\resources\\users.json";
    private UUID id;
    private String username;
    private String avatar;
    private int age;
    public User(){

    }
}
