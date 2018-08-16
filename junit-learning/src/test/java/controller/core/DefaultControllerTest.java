package controller.core;

import junit.framework.TestCase;

public class DefaultControllerTest extends TestCase {
    private DefaultController controller;
    private Request request;
    private  RequestHandler handler;

    @Override
    protected void setUp() throws Exception {
        controller = new DefaultController();
        request = new TestRequest();
        handler = new TestRequestHandler();
        controller.addHandler(request,handler);
    }

    public void testAddHandler(){

        RequestHandler handler1 = controller.getHandler(request);

        assertSame(handler1,handler);
    }

    public void testProcessRequest(){

        Response response = controller.processRequest(request);

        assertNotNull("Must not return a null response",response);
        assertEquals(TestResponse.class, response.getClass());
    }

    @Override
    protected void tearDown() throws Exception {
        throw new RuntimeException("tearDown not implemented yet!!");
    }


    // Mocks

    private class TestRequest implements Request{
        public String getName() {
            return "Test";
        }
    }
    private class TestResponse implements Response{

    }
    private class TestRequestHandler implements RequestHandler{
        public Response process(Request request) throws Exception {
            return new TestResponse();
        }
    }

}