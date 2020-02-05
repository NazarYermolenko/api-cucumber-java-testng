package steps;

import common.api.ToDoApi;
import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class ToDoApiSteps {
    private TestContext testContext;

    public ToDoApiSteps(TestContext context) {
        this.testContext = context;
    }

    @When("User calls API with id {string} as path param")
    public void userCallsAPIWithIdAsPathParam(String id) {
        Response response = new ToDoApi().getToDoById(id);
        testContext.setResponse(response);
    }

    @Then("response status should be {string}")
    public void responseStatusShouldBe(String responseStatus) {
        testContext.getResponse().then().assertThat().statusCode(equalTo(Integer.valueOf(responseStatus)));
    }
}
