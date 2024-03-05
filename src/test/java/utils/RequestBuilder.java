package utils;

import AsanaModel.POST_Project;
import baseTest.BaseTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import static io.restassured.RestAssured.given;

public class RequestBuilder extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger(RequestBuilder.class);


    //ASTANA
    public Response sendGETAstanaRequest_Workspace(String token) {
        Response response = given()
                .auth().oauth2(token)
                .log()
                //.ifValidationFails()
                .all()
                .when()
                .get("/workspaces");
        return response;
    }

    public Response sendGETAstanaRequest_Projects(String token) {
        Response response = given()
                .auth().oauth2(token)
                .log()
                //.ifValidationFails()
                .all()
                .when()
                .get("/projects");
        return response;
    }

    public Response sendPOSTAstanaRequest_with_interpolation(String token, POST_Project project) {
        Response response = given()
                .auth().oauth2(token)
                .log()
                //.ifValidationFails()
                .all()
                .body(project)
                .when()
                .post("workspaces/"+context.getProperty("workspaceID", String.class)+ "/projects");

        return response;
    }

    public Response sendPOSTAstanaRequest_Projects(String token) {
        Response response = given()
                .auth().oauth2(token)
                .log()
                //.ifValidationFails()
                .all()
                .body(new File(PROJECT_CREATE_PATH))
                .when()
                .post("workspaces/"+context.getProperty("workspaceID", String.class)+ "/projects");

        return response;
    }
    public Response sendDELETEAstanaRequest_Projects(String token) {
        Response response = given()
                .auth().oauth2(token)
                .log()
                .all()
                .when()
                .delete("projects/"+context.getProperty("projectID", String.class));

        logger.info(">>>DELETE response:  "+ response.body().prettyPrint());
        return response;
    }
}
