package openAPI_new_framework.client;

import io.restassured.builder.RequestSpecBuilder;
import openAPI_new_framework.requests.student.GetStudent;
import openAPI_new_framework.requests.student.SaveStudent;

import java.util.function.Supplier;

public class ApiClient {
    private final Supplier<RequestSpecBuilder> requestSpecSupplier;

    public ApiClient(Supplier<RequestSpecBuilder> requestSpecSupplier) {
        this.requestSpecSupplier = requestSpecSupplier;
    }

    public SaveStudent saveStudent(String studentName) {
        return new SaveStudent(studentName, requestSpecSupplier.get());
    }

    public GetStudent getStudent(String studentName) {
        return new GetStudent(studentName, requestSpecSupplier.get());
    }
}
