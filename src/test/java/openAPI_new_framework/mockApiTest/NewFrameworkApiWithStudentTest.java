package openAPI_new_framework.mockApiTest;

import openAPI_new_framework.baseTest.NewFrameworkTestBase;
import openAPI_new_framework.client.ApiClient;
import openAPI_new_framework.data.factories.StudentFactory;
import openAPI_new_framework.data.models.Student;
import openAPI_new_framework.data.models.StudentDto;
import openAPI_new_framework.data.models.StudentResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewFrameworkApiWithStudentTest extends NewFrameworkTestBase {
    private ApiClient api;
    private Student expectedStudent;
    private StudentDto actualStudent;
    private StudentFactory studentFactory;
    private final String baseUri = "https://thetestingworldapi.com";


    @BeforeEach()
    public void setupClient() {
        studentFactory = new StudentFactory();
        api = createApiClient(baseUri);
        expectedStudent = studentFactory.createStudent("Sam", "Rachel", "Smith", "01/03/1988");
    }

    @Test
    public void shouldCreateNewStudent()  {
        StudentDto actualStudent = api.saveRealStudent(expectedStudent).saveAsStudentDto();

        assertThat(actualStudent.getId()).isNotZero();
    }

    @Test
    public void shouldGetStudentDetails()  {

        assertThat(api.getRealStudent("10090574").execute().getStatusCode())
                .isEqualTo(HttpStatus.SC_OK);

        assertThat(api.getRealStudent("10090574").asDto())
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(Integer.class)
                .isEqualTo(expectedStudent);
    }
}
