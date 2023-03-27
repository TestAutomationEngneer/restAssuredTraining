package stepdefs;


import AsanaModel.POST_Project;
import AsanaModel.Project;
import AsanaModel.Workspace;
import TestContext.ContextOperations;
import baseTest.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.JsonConnector;
import utils.RequestBuilder;


import java.io.File;

import static org.hamcrest.core.Is.is;

public class StepDefinitionsAstanaAPI extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(StepDefinitionsAstanaAPI.class);
    private Workspace workspace;
    private Project project;
    private POST_Project project_with_interpolation;
    private static String token = data.getToken();


    @Given("I have workspace object")
    public void i_have_workspace_object() {
        workspace = JsonConnector.fillWorkspaceData(new File(WORKSPACE_PATH));
        requestBuilder = new RequestBuilder();
    }

    @Given("I have project object")
    public void i_have_project_object() {
        project = JsonConnector.fillProjectData(new File(PROJECT_PATH));
        requestBuilder = new RequestBuilder();
    }

    @Given("I have project GET object with interpolation")
    public void i_have_project_GET_object_with_interpolation() {
        project = JsonConnector.fillProjectGETInterpolation(new File(PROJECT2_PATH));
        String projectString = JsonConnector.jsonSerializerProjectwithInterpolation(project_with_interpolation);
        requestBuilder = new RequestBuilder();
    }

    @Given("I have project object with interpolation")
    public void i_have_project_object_with_interpolation() {
        project_with_interpolation = JsonConnector.fillProjectDatawithInterpolation(new File(PROJECT_CREATE_PATH));
        String projectString = JsonConnector.jsonSerializerProjectwithInterpolation(project_with_interpolation);
        requestBuilder = new RequestBuilder();
    }

    @When("User perform astana GET projects operation")
    public void user_perform_astana_GET_projects_operation() {
        response = requestBuilder.sendGETAstanaRequest_Projects(token);
    }

    @When("User perform astana GET workspace operation")
    public void user_perform_astana_GET_workspace_operation() {
        response = requestBuilder.sendGETAstanaRequest_Workspace(token);
    }

    @Then("User is able to see response with workspace details")
    public void user_is_able_to_see_response_with_workspace_details() {
        response.then()
                .log()
                .ifValidationFails()
                .body("data[0].gid", is(workspace.getGid()))
                .body("data[0].name", is(workspace.getName()))
                .body("data[0].resource_type", is(workspace.getWorkspace_type()))

                .statusCode(200);
        response = null;
        logger.info("Validation pass ");

    }

    @Then("User is able to see response with projects details")
    public void user_is_able_to_see_response_with_projects_details() {
        response.then()
                .log()
                .body()
                .body("data[0].gid", is(project.getGid()))
                .body("data[0].name", is(project.getName()))
                .body("data[0].resource_type", is(project.getWorkspace_type()))

                .statusCode(200);
        response = null;
        logger.info("Validation pass ");
    }

    @Given("I save data {string}")
    public void i_save_data(String tags) {
        ContextOperations.saveTestContext(tags, context);
    }

    @When("User perform astana GET projects operation with interpolation")
    public void user_perform_astana_GET_projects_operation_with_interpolation() {
        response = requestBuilder.sendGETAstanaRequest_Projects(token);
    }

    @Then("User is able to see response with projects details with interpolation")
    public void user_is_able_to_see_response_with_projects_details_with_interpolation() {
        response.then()
                .log()
                .body()
                .body("data[0].gid", is(project.getGid()))
                .body("data[0].name", is(project.getName()))
                .body("data[0].resource_type", is(project.getWorkspace_type()))

                .statusCode(200);
        response = null;
        logger.info("Validation pass ");
    }

    //ASANA POST PROJECT
    @Given("I have a new project object")
    public void i_have_a_new_project_object() {
        requestBuilder = new RequestBuilder();

    }

    @When("User perform astana POST project")
    public void user_perform_astana_POST_project() {
        response = requestBuilder.sendPOSTAstanaRequest_Projects(token);
    }

    @When("User perform astana POST project with interpolation")
    public void user_perform_astana_POST_project_with_interpolation() {
        response = requestBuilder.sendPOSTAstanaRequest_with_interpolation(token, project_with_interpolation);
    }

    @Then("User is able to see response with new project")
    public void user_is_able_to_see_response_with_new_project() {
        response.then()
                .log()
                .body()
                .body("data.workspace.gid", is(context.getProperty("workspaceID", String.class)))
                .body("data.name", is(context.getProperty("project_name", String.class)))
                .statusCode(201);
        response = null;
        logger.info("Validation pass ");

    }

    @When("User perform astana DELETE project")
    public void user_perform_astana_DELETE_project() {
        requestBuilder = new RequestBuilder();
        response = requestBuilder.sendDELETEAstanaRequest_Projects(token);
    }

    @Then("User is able to see response of deleted project")
    public void user_is_able_to_see_response_of_deleted_project() {
        response.then()
                .log()
                .body().
                body("data", is(Matchers.anEmptyMap()))
                .statusCode(200);
        response = null;
        logger.info("Validation pass ");

    }

}


