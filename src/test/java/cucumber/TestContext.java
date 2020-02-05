package cucumber;

import io.restassured.response.Response;

public class TestContext {
    private Response response;

    public TestContext() {
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return this.response;
    }
}
