package openAPI_new_framework.mockApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

public class StudentDetailsTest {
    String requestBody1 =
            "{\n" +
                    "    \"first_name\": \"Angelina\",\n" +
                    "    \"middle_name\": \"Jolie\",\n" +
                    "    \"last_name\": \"Camila\",\n" +
                    "    \"date_of_birth\": \"01/03/1977\"\n" +
                    "}";

    String requestBody2 = """
            {
                "first_name": "Angelina",
                "middle_name": "Jolie",
                "last_name": "Camila",
                "date_of_birth": "01/03/1977"
            }
    """;

    String requestBodyAfterUpdate = """
            {
                "id": "3937429",
                "first_name": "Camila",
                "middle_name": "Julia",
                "last_name": "Cabello",
                "date_of_birth": "01/03/1988"
            }
    """;


    //POST
    @Test
    public void shouldPOSTNewStudent() {
        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(requestBody2)
                .post()
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    //GET
    @Test
    public void shouldGETNewStudentSimpleString() {
        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .pathParam("studentid", "3937429")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("/{studentid}")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    //PUT
    @Test
    public void shouldUPDATENewStudent() {
        String studentId = "3937429";
        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .pathParam("studentid", studentId)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .body(requestBodyAfterUpdate)
                .put("/{studentid}")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    //DELETE
    @Test
    public void shouldDELETENewStudent() {
        String studentId = "3937429";
        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("api/studentsDetails")
                .pathParam("studentid", studentId)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete("/{studentid}")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
