package controller.core;

public interface RequestHandler {
    Response process(Request request) throws Exception;
}
