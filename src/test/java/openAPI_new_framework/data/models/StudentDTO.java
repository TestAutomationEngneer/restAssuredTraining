package openAPI_new_framework.data.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class StudentDTO {

    private String name;

    public StudentDTO(String name) {
        this.name = name;
    }

    public StudentDTO() {
    }
}
