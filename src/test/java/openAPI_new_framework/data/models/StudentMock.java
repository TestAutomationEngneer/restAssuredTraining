package openAPI_new_framework.data.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StudentMock {

    private String name;

    public StudentMock(String name) {
        this.name = name;
    }

    public StudentMock() {
    }
}
