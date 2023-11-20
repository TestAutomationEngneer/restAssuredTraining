package openAPI_new_framework.mockApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class BasicRestAssuredTest {

    @BeforeEach
    public void setUp() {

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://api.openweathermap.org";
      //  RestAssured.basePath = "/data/2.5/weather";
//
//        //start serwer
        RestAssured.port = 8811;
    }

    @Test
    public void shouldGETweatherForLocation() {
        given()
                .baseUri("https://api.openweathermap.org")
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

        //fail 401 - potrzebny parametr appId - https://openweathermap.org/appid
    }

    @Test
    public void shouldGETweatherForLocationWithParamAuth() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

        //fail 400 - potrzebny id - https://openweathermap.org/current#name
    }

    @Test
    public void shouldGETweatherForLocationWithParamAuthAndLocation() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

       //ok - param id dla Warszawy 6695624
    }

    // >>>>>>>>>>>>>>>>>  Dodajemy logowanie

    @Test
    public void shouldGETweatherForLocationWithLogsParams() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .log().params()
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

        //ok - param id dla Warszawy 6695624
    }

    @Test
    public void shouldGETweatherForLocationWithLogsBody() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .log().body()
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

        //ok - body none
    }
    @Test
    public void shouldGETweatherForLocationWithLogsAll() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

        //ok - log all
    }

    // Dodajemy headers

    @Test
    public void shouldGETweatherForLocationWithHeader() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .header("myname","Darek")
                .log().all()
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

        //dodajemy własny header
//        given()
//          .auth().oauth2(token)

        given().headers("User-Agent", "MyAppName", "Accept-Charset", "utf-8");
    }
    @Test
    public void shouldGETweatherForLocationWithPathParam1() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .pathParam("extend", "forecast")
                .header("myname","Darek")
                .log().all()
                .when()
                .get("/data/2.5/{extend}")
                .then()
                .statusCode(200);
    }

    @Test
    public void shouldGETweatherForLocationWithPathParam2() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .pathParam("extend", "forecast")
                .pathParam("apiVersion", "2.5")
                .header("myname","Darek")
                .log().all()
                .when()
                .get("/data/{apiVersion}/{extend}")
                .then()
                .statusCode(200);

        // pathparam apiVersion i extend
    }
    //session i cookie
    @Test
    public void shouldGETweatherForLocationWithCookie() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .cookie("sessionid","5511")
                .log().all()
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200);

        //
    }
   // Logowanie na podstawie cookie
    private Cookies cookie;

    //@Before
    public void shouldLoginToTheSystem() {
        String body = "body of my payload";
        cookie = RestAssured.given()
                .param("id", "22")
                .when()
                .body(body)
                .post("/api/google")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .getDetailedCookies();
    }

    @Test
    public void performActionsBasedOnCookies() {
//ustaw cookie przed wysłaniem metody POST
        RestAssured.given()
                .cookies(cookie)
                .when()
                .post("/api/bank/loan")
                .then()
                .statusCode(201);
    }

    // <<<<<<<<<<<< Response

    @Test
    public void shouldSeeLondonResponse() {
        given()
                .baseUri("https://api.openweathermap.org")
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","2643743")
                .log().all()
                .when()
                .get("/data/2.5/weather")
                .then().log().all()
                .statusCode(200);

        //ok
    }
}
