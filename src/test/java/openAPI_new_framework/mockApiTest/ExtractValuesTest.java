package openAPI_new_framework.mockApiTest;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import openAPI_new_framework.data.DataStore;
import openAPI_new_framework.data.models.Student;
import openAPI_new_framework.data.models.StudentResponse;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ExtractValuesTest {

//------------ .extract() do Data Store--------------------

    @Test
    public void getweatherforLondonDataStore() {


        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q", "London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();


        DataStore.WIND_DEG = given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .extract()
                .jsonPath().get("wind.deg");

        System.out.println(">>>>>>>>>>>> extracted value is: " + DataStore.WIND_DEG + ">>>>>>>>>>>");
    }
//------------ .extract() do TypeRef --------------------

            //GET
            @Test
            public void shouldGETNewStudentandExtractAsTypeRef() {
                StudentResponse actualStudent = given()
                        .baseUri("https://thetestingworldapi.com/")
                        .basePath("api/studentsDetails")
                        .pathParam("studentid", "8529230")
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get("/{studentid}")
                        .then()
                        .statusCode(200)
                        .log()
                        .all()
                        .extract()
                        .as(new TypeRef<StudentResponse>(){});

                System.out.println("Student as TypeRef = " +actualStudent);
            }
    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondonbodyValidation() {

        //float expectedSpeed =  4.1f;
        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();

        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .body("wind.speed", is(4.1f));

    }
    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondonbodyValidationName() {


        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();

        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .body("name", equalTo("London"));

    }
    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondonbodyValidationWind() {

        //float expectedSpeed =  4.1f;
        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();

        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .body("wind.speed", greaterThan(4.0f));

    }

    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondonbodyValidationSys() {

        //float expectedSpeed =  4.1f;
        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();

        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .body("sys", hasEntry("country", "GB"));

    }
    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondonbodyValidationEmpty() {

        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();

        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .body("sys", empty()); //fail

    }
    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondonbodyValidationHasValue() {


        //float expectedSpeed =  4.1f;

        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();

        given()
                .spec(specification)
                //.when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .body("sys", hasValue("GB"));

    }

}
