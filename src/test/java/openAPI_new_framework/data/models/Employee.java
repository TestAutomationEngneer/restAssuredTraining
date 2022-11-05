package openAPI_new_framework.data.models;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;
@Data
public class Employee {

    private UUID id;
    private String name;
    private int age;
    private Instant startWorkingDate;

    public Employee(UUID id, String name, int age, Instant startWorkingDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.startWorkingDate = startWorkingDate;
    }
}
