package controller.core;

public class ErrorResponse implements Response{
    private Request request;
    private Exception exception;

    public ErrorResponse(Request request, Exception exception) {
        this.request = request;
        this.exception = exception;
    }

    public Request getRequest() {
        return request;
    }

    public Exception getException() {
        return exception;
    }
}
