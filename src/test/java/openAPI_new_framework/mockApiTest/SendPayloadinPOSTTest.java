package openAPI_new_framework.mockApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import openAPI_new_framework.data.models.Student;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasValue;

public class SendPayloadinPOSTTest {
    String requestBody =
            "{\n" +
                    "    \"first_name\": \"Angelina\",\n" +
                    "    \"middle_name\": \"Jolie\",\n" +
                    "    \"last_name\": \"Camila\",\n" +
                    "    \"date_of_birth\": \"01/03/1977\"\n" +
                    "}";

    //Student map
    Map<String, String> studentMap = new HashMap<>();

    //Student object
    Student studentObj;


    //wypełnianie request body POST Student - simple local String

    @Test
    public void createNewStudentSimpleString() {

        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(requestBody)
                .post()
                .then()
                .statusCode(201)
                .log()
                .all();

    }

    //wypełnianie request body POST Student - Map

    @Test
    public void createNewStudentMap() {

        studentMap.put("first_name", "Brad");
        studentMap.put("middle_name", "Janusz");
        studentMap.put("last_name", "Pitt");
        studentMap.put("date_of_birth", "01/03/1977");

        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .contentType(ContentType.JSON)
                .log()
                .body()
                .when()
                .body(studentMap)
                .post()
                .then()
                .statusCode(201)
                .log()
                .all();

    }

    //wypełnianie request body POST Student - Object

    @Test
    public void createNewStudentObject() {

        studentObj= new Student("Salma", "Joanna", "Hayek", "01/03/1977");

        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(studentObj)
                .post()
                .then()
                .statusCode(201)
                .log()
                .all();

    }

    //wypełnianie request body POST Student - File

    @Test
    public void createNewStudentFile() {


        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .contentType(ContentType.JSON)
                .log()
                .body()
                .when()
                .body(new File("src/test/resources/Student.json"))
                .post()
                .then()
                .statusCode(201)
                .log()
                .all();

    }
}
