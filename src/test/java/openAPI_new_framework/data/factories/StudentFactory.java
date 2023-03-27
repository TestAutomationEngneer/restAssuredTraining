package openAPI_new_framework.data.factories;

import openAPI_new_framework.data.models.StudentDTO;

public class StudentFactory {
    public StudentDTO studentDTO;
    public StudentFactory() {
    }

    public StudentDTO customizeStudent(String name) {
        studentDTO = new StudentDTO(name);
        return studentDTO;
    }
}
