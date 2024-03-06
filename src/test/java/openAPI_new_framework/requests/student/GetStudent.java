package openAPI_new_framework.requests.student;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import openAPI_new_framework.client.ExecutableRequest;
import openAPI_new_framework.data.models.Student;
import openAPI_new_framework.data.models.StudentDto;
import openAPI_new_framework.data.models.StudentResponse;

import static io.restassured.RestAssured.given;

public class GetStudent implements ExecutableRequest {

    private final RequestSpecBuilder requestSpecBuilder;

    public GetStudent(String studentId, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setAccept(ContentType.JSON);
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("studentid", studentId);
    }

    @Override
    public Response execute() {
        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .get("/api/studentsDetails/{studentid}");
    }


    //map StudentResponse to StudentDto
    public StudentDto asDto() {
        StudentResponse studentResponse = execute()
                .then()
                .extract()
                .as(StudentResponse.class);
        return new StudentDto(
                studentResponse.getData().getId(),
                studentResponse.getData().getFirst_name(),
                studentResponse.getData().getMiddle_name(),
                studentResponse.getData().getLast_name(),
                studentResponse.getData().getDate_of_birth());
    }
}
