package openAPI_new_framework.mockApiTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import openAPI_new_framework.data.DataStore;
import openAPI_new_framework.data.models.Student;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RequestResponseSpecificationTest {

    //---------------------RequestSpecification specification param ------------

    @Test
    public void getweatherforLondonReqSpecification() {

        RequestSpecification specification = given()
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
                .statusCode(200);
    }

    //---------------------RequestSpecification specification param + header ------------
    @Test
    public void getweatherforLondon5() {


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
                .statusCode(200);

    }

    //---------------------Request Specification i ResponseSpecification  ------------
    @Test
    public void getweatherforLondon15() {
        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();

        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.log().all();
        responseSpecification.time(Matchers.lessThan(5000L));
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.statusCode(200);

        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=2b1fd2d7f77ccf1b7de9b441571b39b8")
                .then()
                .spec(responseSpecification);

    }
    //---------------------ResponseSpecification specification ------------

    @Test
    public void getweatherforLondon6() {


        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();


        float validatableResponse = given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .extract()
                .path("wind.speed");

        System.out.println(">>>>>>>>>>>> extracted value is: "+ validatableResponse + ">>>>>>>>>>>");
        //asercja(4.1)

    }

//------------ .extract() do Data Store--------------------

    @Test
    public void getweatherforLondon8() {


        RequestSpecification specification = given()
                .header("name", "Darek")
                .header("age", "25")
                .param("q","London,uk")
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

        System.out.println(">>>>>>>>>>>> extracted value is: "+ DataStore.WIND_DEG + ">>>>>>>>>>>");


    }
    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondon9() {

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
    public void getweatherforLondon10() {


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
    public void getweatherforLondon11() {

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
    public void getweatherforLondon21() {

        Map<String, Object> context = new LinkedHashMap<>();
        context.put("type", 1);
        context.put("id", 5091);
        context.put("message", 0.0103);
        context.put("country", "GB");
        context.put("sunrise", 1485762037);
        context.put("sunset", 1485794875);
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
    public void getweatherforLondon22() {

        Map<String, Object> context = new LinkedHashMap<>();
        context.put("type", 1);
        context.put("id", 5091);
        context.put("message", 0.0103);
        context.put("country", "GB");
        context.put("sunrise", 1485762037);
        context.put("sunset", 1485794875);
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
                .body("sys", empty());

    }
    //------------ .response body validation--------------------
    @Test
    public void getweatherforLondon23() {

        Map<String, Object> context = new LinkedHashMap<>();
        context.put("type", 1);
        context.put("id", 5091);
        context.put("message", 0.0103);
        context.put("country", "GB");
        context.put("sunrise", 1485762037);
        context.put("sunset", 1485794875);
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
                .body("sys", hasValue("PL"));

    }
    //------------ .response body validation--------------------

}
