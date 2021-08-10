package api.services;

import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import api.models.User;

import java.util.*;
import java.util.stream.Collectors;

import static api.utils.DataUtils.mergeObjects;
import static api.utils.FileUtils.*;

public class UserService implements BaseService<User> {

    @Override
    public List<User> getAll() {
        return readList(User.RESOURCE_DIR, new TypeToken<List<User>>() {
        }.getType());
    }

    @Override
    public User getById(String id) {
        List<User> users = this.getAll();
        return users.stream().filter(user -> id.equals(user.getId().toString())).findFirst().orElse(null);
    }

    @Override
    public User create(User user) {
        List<User> users = this.getAll();
        user.setId(UUID.randomUUID());
        users.add(user);
        writeList(User.RESOURCE_DIR, users);

        return user;
    }

    @Override
    public User delete(String id) {
        List<User> users = this.getAll();
        users = users.stream()
                .filter(user -> !id.equals(user.getId().toString()))
                .collect(Collectors.toList());
        writeList(User.RESOURCE_DIR, users);

        return null;
    }

    @SneakyThrows
    @Override
    public User update(String id, User updatedData) {
        User user = this.getById(id);
        List<User> users = this.getAll();
        User updatedUser = mergeObjects(user, updatedData, new User());
        users = users.stream()
                .filter(u -> !updatedUser.getId().equals(u.getId()))
                .collect(Collectors.toList());
        users.add(updatedUser);
        writeList(User.RESOURCE_DIR, users);

        return updatedUser;
    }
}
