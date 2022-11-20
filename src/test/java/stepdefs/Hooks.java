package stepdefs;


import baseTest.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class Hooks extends BaseTest {


    @Before(order = 1)                //executed before each single scenario
    public void initData(Scenario scenario) {
        //ASTANA
        RestAssured.baseURI = data.getAstanabaseURI();
        RestAssured.basePath = data.getAstanabasePath();
        System.out.println("Before completed");
    }


    @After                              //executed after each single scenario
    public void tearDown(Scenario scenario) {

        System.out.println("AFTER. SCENARIO NAME =  " + scenario.getName() + ". STATUS =  " + scenario.getStatus());
    }
}

