package api.models.response;


import java.util.List;

public class ListResponse<T> extends Response {
    protected List<T> data;

    public ListResponse(List<T> data, String message) {
        super(message);
        this.data = data;
    }
}
