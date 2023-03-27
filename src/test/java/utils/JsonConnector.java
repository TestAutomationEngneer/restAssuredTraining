package utils;

import AsanaModel.POST_Project;
import AsanaModel.Project;
import AsanaModel.Workspace;

import TestData.Data;
import TestData.StringReplacement;
import baseTest.BaseTest;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import models.Student;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class JsonConnector extends BaseTest {
    private static Logger logger = LoggerFactory.getLogger(JsonConnector.class);

    public static Data readData(File file) {
        try {
            Gson parser = new Gson();
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            Data data = parser.fromJson(buffer, Data.class);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //Workspace object

    public static Workspace fillWorkspaceData(File file) {
        try {
            Gson parser = new Gson();
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            Workspace workspace = parser.fromJson(buffer, Workspace.class);
            logger.info("Workspace has been loaded properly: {}", workspace);
            return workspace;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String jsonSerializerWorkspace(Workspace workspace) {
        Gson gson = new Gson();
        return gson.toJson(workspace);
    }

    //Project object

    public static Project fillProjectData(File file) {
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            Project project = parser.fromJson(buffer, Project.class);
            logger.info("Project has been loaded properly: {}", project);
            return project;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String jsonSerializerProject(Project project) {
        Gson gson = new Gson();
        return gson.toJson(project);
    }

    public static String jsonSerializerProjectwithInterpolation(POST_Project project) {
        Gson gson = new Gson();
        return gson.toJson(project);
    }

    public static POST_Project fillProjectDatawithInterpolation(File file) {
        try {
            Gson parser = new Gson();
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String rawProject = IOUtils.toString(buffer);
            String projectInterpolated =  StringReplacement.formatString(rawProject, context);

            POST_Project project = parser.fromJson(new BufferedReader(new StringReader(projectInterpolated)), POST_Project.class);
            logger.info(" Project:  " + projectInterpolated);
            return project;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Project fillProjectGETInterpolation(File file) {
        try {
            Gson parser = new Gson();
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String rawProject = IOUtils.toString(buffer);
            String projectInterpolated =  StringReplacement.formatString(rawProject, context);

            Project project = parser.fromJson(new BufferedReader(new StringReader(projectInterpolated)), Project.class);
            logger.info(" Project:  " + projectInterpolated);
            return project;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
