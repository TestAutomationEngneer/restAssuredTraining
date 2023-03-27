package baseTest;


import TestContext.TestContext;
import TestData.Data;
import com.google.gson.Gson;
import io.restassured.response.Response;
import utils.JsonConnector;
import utils.RequestBuilder;

import java.io.File;

public class BaseTest {
    protected static TestContext context = TestContext.getInstance();
    protected final static String DATA_PATH = "src/test/java/TestData/Data.json";
    protected final static String WORKSPACE_PATH = "src/test/java/TestData/Workspace.json";
    protected final static String PROJECT_PATH = "src/test/java/TestData/Project.json";
    protected final static String PROJECT2_PATH = "src/test/java/TestData/Project_with_interpolation.json";
    protected final static String PROJECT_POST_PATH = "src/test/java/TestData/Project_with_interpolation.json";
    protected final static String PROJECT_CREATE_PATH = "src/test/java/TestData/Create_project.json";
    protected static Data data =  JsonConnector.readData(new File(DATA_PATH));
    protected Response response;
    protected RequestBuilder requestBuilder;
    protected static Gson parser = new Gson();

}
