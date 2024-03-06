package openAPI_new_framework.client;

import io.restassured.builder.RequestSpecBuilder;
import openAPI_new_framework.data.models.Student;
import openAPI_new_framework.requests.student.GetStudent;
import openAPI_new_framework.requests.student.GetStudentMock;
import openAPI_new_framework.requests.student.SaveStudent;
import openAPI_new_framework.requests.student.SaveStudentMock;

import java.util.function.Supplier;

public class ApiClient {
    private final Supplier<RequestSpecBuilder> requestSpecSupplier;

    public ApiClient(Supplier<RequestSpecBuilder> requestSpecSupplier) {
        this.requestSpecSupplier = requestSpecSupplier;
    }

    public SaveStudentMock saveMockedStudent(String studentName) {
        return new SaveStudentMock(studentName, requestSpecSupplier.get());
    }

    public GetStudentMock getMockedStudent(String studentName) {
        return new GetStudentMock(studentName, requestSpecSupplier.get());
    }

    public SaveStudent saveRealStudent(Student student) {
        return new SaveStudent(student, requestSpecSupplier.get());
    }

    public GetStudent getRealStudent(String studentid) {
        return new GetStudent(studentid, requestSpecSupplier.get());
    }
}
