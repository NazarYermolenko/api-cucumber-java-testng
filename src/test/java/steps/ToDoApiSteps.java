package steps;

import common.api.ToDoApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import runner.TestRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToDoApiSteps extends TestRunner {
    private Response response;

    @When("User calls API with id {string} as path param")
    public void userCallsAPIWithIdAsPathParam(String id) {
        this.response = new ToDoApi().getToDoById(id);
    }

    @Then("response status should be {string}")
    public void responseStatusShouldBe(String responseStatus) {
        this.response.then().assertThat().statusCode(equalTo(Integer.valueOf(responseStatus)));
    }

    @And("body should contain parameter {string} equals to {string}")
    public void bodyShouldContainParameterEqualToValue(String param, String value) {
        assertThat(this.response.then().extract().body().jsonPath().get(param).toString(), equalTo(value));
    }
}
