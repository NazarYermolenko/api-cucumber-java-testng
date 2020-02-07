package common.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApi {
    protected RequestSpecification requestSpecification;

    protected BaseApi() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpecification = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri("https://jsonplaceholder.typicode.com");
    }
}
