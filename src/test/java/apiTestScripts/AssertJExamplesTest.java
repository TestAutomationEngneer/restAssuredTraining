package apiTestScripts;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {

    private static RequestSpecification requestSpec;

    @BeforeAll
    public static void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setBaseUri("http://localhost:3000/")
                .setBasePath("/student")
                .build();
    }

    @Test
    public void shouldCreateNewStudentFromMapAssertionFail() {
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("name", "Angelina");
        studentMap.put("age", "30");
        String total = RestAssured.given()
                .spec(requestSpec)
                .body(studentMap)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("total");
       assertThat(total).as("Total coutn of items").isEqualTo("110"); //jest celowy błąd, pokazać message z as()
    }

    @Test
    public void shouldCreateNewStudentFromMapAssertion1() {
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("name", "Angelina");
        studentMap.put("age", "30");
        String total = RestAssured.given()
                .spec(requestSpec)
                .body(studentMap)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("total");
        //assertThat(Integer.parseInt(total)).as("Total coutn of items").isGreaterThan(Integer.parseInt("2"));
        assertThat(total).as("Total coutn of items").isGreaterThan("2");
        //konieczne parsowanie na int, bo ze stringiem wyjdą nieoczekiwane rezultaty
    }
}
