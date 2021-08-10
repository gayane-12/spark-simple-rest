package api.models.response;

public class ObjectResponse<T> extends Response {
    protected T data;

    public ObjectResponse(T data, String message) {
        super(message);
        this.data = data;
    }
}
