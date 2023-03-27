package apiTestScripts;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import models.TransactionDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecificationMockApiTests {

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
    public void shouldCreateNewStudentFromMap() {
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
        System.out.println("Total count = " + total);
    }

    @Test
    public void shouldGETTransactionsDetails() {
        TransactionDTO expected = new TransactionDTO();
        var actual = RestAssured.given()
                .baseUri("http://localhost:3000")
                .basePath("/transactions")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                //.as(new TypeRef<List<TransactionDTO>>(){}); tutaj zadziała Lista
                .as(new TypeRef<TransactionDTO[]>(){}); //i tablica
    }
}
