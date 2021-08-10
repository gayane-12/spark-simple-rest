package api.routes;

import api.controllers.UserController;

import static api.helpers.ResponseTransformer.json;
import static spark.Spark.*;

public class UserRouter {

    public static void init() {
        path("/users", () -> {
            before("/*", (req, res) -> System.out.println("Received api call"));

            get("", UserController::getAll, json());
            post("", UserController::create, json());

            get("/:id", UserController::getById, json());
            delete("/:id", UserController::deleteById, json());
            put("/:id", UserController::update, json());
        });
    }
}
