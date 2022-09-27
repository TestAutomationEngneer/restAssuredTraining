package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

    @Given("Student object is created")
    public void student_object_is_created() {
        System.out.println("Student object is created");
    }

    @When("User send GET request")
    public void user_send_get_request() {
        System.out.println("User send GET request");
    }

    @Then("User is able to read student details")
    public void user_is_able_to_read_student_details() {
        System.out.println("User is able to read student details");
    }

}
