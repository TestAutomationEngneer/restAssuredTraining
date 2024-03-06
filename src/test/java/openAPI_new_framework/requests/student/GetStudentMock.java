package openAPI_new_framework.requests.student;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import openAPI_new_framework.client.ExecutableRequest;
import openAPI_new_framework.data.models.StudentMock;

import static io.restassured.RestAssured.*;

public class GetStudentMock implements ExecutableRequest {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetStudentMock(String name, RequestSpecBuilder requestSpecBuilder) {
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

    public StudentMock asDto() {
        return execute()
                .then()
                .extract()
                .as(StudentMock.class);
    }
}
