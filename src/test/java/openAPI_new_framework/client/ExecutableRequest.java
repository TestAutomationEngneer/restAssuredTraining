package openAPI_new_framework.client;

import io.restassured.response.Response;

@FunctionalInterface
public interface ExecutableRequest {
    Response execute();
}
