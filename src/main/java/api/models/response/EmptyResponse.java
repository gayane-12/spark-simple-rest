package api.models.response;

public class EmptyResponse extends Response {
    protected String data;

    public EmptyResponse(String message) {
        super(message);
        this.data = "";
    }
}
