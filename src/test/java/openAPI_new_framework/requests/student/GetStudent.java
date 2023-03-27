package openAPI_new_framework.requests.student;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import openAPI_new_framework.client.ExecutableRequest;
import openAPI_new_framework.data.models.StudentDTO;

import static io.restassured.RestAssured.*;

public class GetStudent implements ExecutableRequest {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetStudent(String name, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setAccept(ContentType.JSON);
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("name", name);
    }

    @Override
    public Response execute() {
        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .get("/studentDetails/{name}");
    }

    public StudentDTO asDto() {
        return execute()
                .then()
                .extract()
                .as(StudentDTO.class);
    }
}
