package common.api;

import io.restassured.response.Response;

public class ToDoApi extends BaseApi {

    public ToDoApi(){
        requestSpecification.basePath("todos");
    }

    public Response getToDoById(String id){
        return requestSpecification.pathParam("id", id).get("{id}");
    }
}
