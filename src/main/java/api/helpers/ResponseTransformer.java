package api.helpers;

import api.utils.JsonUtils;

public class ResponseTransformer {

    public static spark.ResponseTransformer json() {
        return JsonUtils::toJson;
    }

}
