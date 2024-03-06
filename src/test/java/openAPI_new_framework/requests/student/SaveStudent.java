package openAPI_new_framework.requests.student;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import openAPI_new_framework.client.ExecutableRequest;
import openAPI_new_framework.data.models.Student;
import openAPI_new_framework.data.models.StudentDto;
import openAPI_new_framework.data.models.StudentResponse;

import static io.restassured.RestAssured.given;

public class SaveStudent implements ExecutableRequest {

    private final RequestSpecBuilder requestSpecBuilder;

    public SaveStudent(Student student, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        //this.requestSpecBuilder.addPathParam("key1", "value1");
        //this.requestSpecBuilder.addQueryParam("key2", "value2");
        this.requestSpecBuilder.setBody(student);
    }


    @Override
    public Response execute() {
        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .post("/api/studentsDetails");
    }

    public String extractStudentId() {
        return execute()
                .then()
                .extract()
                .jsonPath()
                .get("id");
    }

    public StudentDto saveAsStudentDto() {
        return execute()
                .then()
                .extract()
                .as(new TypeRef<StudentDto>(){});
    }
}
