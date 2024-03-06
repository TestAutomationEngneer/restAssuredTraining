package openAPI_new_framework.data.factories;

import openAPI_new_framework.data.models.Student;
import openAPI_new_framework.data.models.StudentMock;

public class StudentFactory {
    public StudentMock studentDTO;
    public StudentFactory() {
    }

    public StudentMock customizeStudent(String name) {
        studentDTO = new StudentMock(name);
        return studentDTO;
    }

    public Student createStudent(String first_name, String middle_name, String last_name, String date_of_birth) {
        return new Student(first_name, middle_name, last_name, date_of_birth);
    }
}
