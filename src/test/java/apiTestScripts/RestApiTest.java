package apiTestScripts;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class RestApiTest {
    private int id;
    String requestBody =
            """
                            {
                                "first_name": "Angelina",
                                "middle_name": "Jolie",
                                "last_name": "Pamela",
                                "date_of_birth": "01/03/1977"
                            }
                    """;


    String requestBodyforUPDATE = """
                 {
                    "id": 3849896,
                        "first_name": "Salma",
                        "middle_name": "Cristina",
                        "last_name": "Hayek",
                        "date_of_birth": "03/10/1980"
                }
            """;


    @Test
    void shouldStartsWithD() {
        String name = "Darek";
        assertThat(name).startsWith("D");
    }

    @Test
    public void shouldCreateNewStudent() {

        id = RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .basePath("/api/studentsDetails")
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
        System.out.println("New student id = " + id);
    }

    @Test
    void shouldSendGETrequestWithStudent() {
        int id = 3849875;
        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .contentType(ContentType.JSON)
                .when()
                .log()
                .all()
                .get("/api/studentsDetails/" + id)
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("data.id", is(id));
    }

    @Test
    void shouldDELETEStudent() {
        int id = 3849889;
        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .contentType(ContentType.JSON)
                .when()
                .log()
                .all()
                .delete("/api/studentsDetails/" + id)
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("status", is("true"));
    }

    @Test
    void shouldUPDATEStudent() {
        int id = 3849896;
        RestAssured.given()
                .baseUri("https://thetestingworldapi.com/")
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyforUPDATE)
                .log()
                .all()
                .put("/api/studentsDetails/" + id)
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("msg", is("update  data success"));
    }
}
