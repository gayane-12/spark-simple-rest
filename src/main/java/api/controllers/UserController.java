package api.controllers;

import api.enums.ResponseStatuses;
import api.models.response.EmptyResponse;
import api.models.response.ListResponse;
import api.models.response.ObjectResponse;
import com.google.gson.Gson;
import api.models.User;
import api.services.UserService;

import spark.Request;
import spark.Response;

import java.util.List;

import static api.utils.JsonUtils.queryStringtoJson;

public class UserController {
    private static UserService userService = new UserService();

    public static ListResponse<User> getAll(Request req, Response res) {
        List<User> users = userService.getAll();
        res.status(ResponseStatuses.SUCCESS.getCode());
        res.type("application/json");

        return new ListResponse<>(users, ResponseStatuses.SUCCESS.getMessage());
    }

    public static ObjectResponse<User> create(Request req, Response res) {
        String requestData = req.body();
        User userData = new Gson().fromJson(queryStringtoJson(requestData), User.class);
        User user = userService.create(userData);
        res.status(ResponseStatuses.CREATED.getCode());
        res.type("application/json");

        return new ObjectResponse<>(user, ResponseStatuses.CREATED.getMessage());
    }

    public static ObjectResponse<User> getById(Request req, Response res) {
        String id = req.params(":id");
        System.out.println("plp"+id);
        User user = userService.getById(id);
        res.status(ResponseStatuses.SUCCESS.getCode());
        res.type("application/json");

        return new ObjectResponse<>(user, ResponseStatuses.SUCCESS.getMessage());
    }

    public static EmptyResponse deleteById(Request req, Response res) {
        String id = req.params(":id");
        userService.delete(id);
        res.status(ResponseStatuses.SUCCESS.getCode());
        res.type("application/json");

        return new EmptyResponse(ResponseStatuses.SUCCESS.getMessage());
    }

    public static ObjectResponse<User> update(Request req, Response res) {
        String id = req.params(":id");
        User updatedData = new Gson().fromJson(queryStringtoJson(req.body()), User.class);
        User user = userService.update(id, updatedData);
        res.status(ResponseStatuses.CREATED.getCode());
        res.type("application/json");

        return new ObjectResponse<>(user, ResponseStatuses.SUCCESS.getMessage());
    }

}
