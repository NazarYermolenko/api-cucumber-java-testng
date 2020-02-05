package steps;

import cucumber.TestContext;
import io.cucumber.java.en.And;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BaseSteps {
    private TestContext testContext;

    public BaseSteps(TestContext context) {
        this.testContext = context;
    }

    @And("body should contain parameter {string} equals to {string}")
    public void bodyShouldContainParameterEqualToValue(String param, String value) {
        assertThat(testContext.getResponse().then().extract().body().jsonPath().get(param).toString(), equalTo(value));
    }
}
