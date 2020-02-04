package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.github.fge.jsonschema.main.*;
import runner.TestRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ToDoApiSteps extends TestRunner {
    private RequestSpecification requestSpecification;
    private Response response;

    @Given("Get ToDo API")
    public void getToDoAPI() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        this.requestSpecification = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("todos");
    }


    @When("User calls API with id {string} as path param")
    public void userCallsAPIWithIdAsPathParam(String id) {
        this.response = this.requestSpecification.pathParam("id", id).get("{id}");
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
