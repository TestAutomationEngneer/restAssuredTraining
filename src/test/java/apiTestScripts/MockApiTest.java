package apiTestScripts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Student;
import models.Student2;
import models.StudentRecord;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MockApiTest {
    String requestBody =
            """
            {
             "name": "darek"
            }
            """;

    private Student2 student;
    private StudentRecord studentRecord;
    @Test
    public void shouldCreateNewStudent() {



        RestAssured.given()
                .baseUri("http://localhost:3000/")
                .basePath("/student")
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody)
                .post()
                .then()
                .statusCode(201)
                .log()
                .all()
                .extract()
                .path("id");
        //System.out.println("New student id = " + id);
    }

    @Test
    public void shouldCreateNewStudentFromObject() {
        student = new Student2("Brad", 30);
        String total = RestAssured.given().log().all()
                .baseUri("http://localhost:3000/")
                .basePath("/student")
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .post()
                .then()
                .statusCode(201)
                .log()
                .all()
                .extract()
                .path("total");
        System.out.println("Total count = " + total);
    }

    @Test
    public void shouldCreateNewStudentFromRecord() {
        studentRecord = new StudentRecord("Brad", 30);
        String total = RestAssured.given().log().all()
                .baseUri("http://localhost:3000/")
                .basePath("/student")
                .contentType(ContentType.JSON)
                .body(studentRecord)
                .when()
                .post()
                .then()
                .statusCode(201)
                .log()
                .all()
                .extract()
                .path("total");
        System.out.println("Total count = " + total);
    }

    @Test
    public void shouldCreateNewStudentFromMap() {
       Map<String, Object> studentMap = new HashMap<>();
       studentMap.put("name", "Angelina");
       studentMap.put("age", "30");
        String total = RestAssured.given().log().all()
                .baseUri("http://localhost:3000/")
                .basePath("/student")
                .contentType(ContentType.JSON)
                .body(studentMap)
                .when()
                .post()
                .then()
                .statusCode(201)
                .log()
                .all()
                .extract()
                .path("total");
        System.out.println("Total count = " + total);
    }
}
