package openAPI_new_framework.mockApiTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import openAPI_new_framework.baseTest.MockTestBase;
import openAPI_new_framework.client.ApiClient;
import openAPI_new_framework.data.factories.StudentFactory;
import openAPI_new_framework.data.models.StudentDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MockApiTest extends MockTestBase {
    private ApiClient api;
    private String studentName;

    private StudentFactory studentFactory;
    private final String STUDENT_PATH = "/studentDetails/.*";

    @BeforeEach()
    public void createApiClient() {
        studentFactory = new StudentFactory();
        api = createApiClient(mock.baseUrl());
        studentName = RandomStringUtils.random(8, true, false).toLowerCase();

        mock.stubFor(post(urlPathMatching(STUDENT_PATH))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_CREATED))
        );
        api.saveStudent(studentName)
                .execute()
                .then()
                .statusCode(HttpStatus.SC_CREATED);
    }


    @Test
    public void shouldCreateNewStudent() throws JsonProcessingException {

        StudentDTO expectedStudent = studentFactory.customizeStudent(studentName);
        mock.stubFor(get(urlPathMatching(STUDENT_PATH))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_OK)
                        .withHeader("Content-Type", ContentType.JSON.toString())
                        .withBody(writer.writeValueAsString(expectedStudent)))
        );

        assertThat(api.getStudent(studentName).execute().getStatusCode())
                .isEqualTo(HttpStatus.SC_OK);
        assertThat(api.getStudent(studentName).asDto())
                .usingRecursiveComparison()
                .isEqualTo(expectedStudent);
    }
}
