package api.enums;

public enum ResponseStatuses {
    SUCCESS(200, "OK"),
    CREATED(201, "Created"),
    NOT_FOUND(404, "File Not Found"),
    BAD_REQUEST(400, "Bad Request");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String message(String mess) {
        message = mess;
        return message;
    }

    public String getResponse() {
        return code + " " + message;
    }

    ResponseStatuses(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
