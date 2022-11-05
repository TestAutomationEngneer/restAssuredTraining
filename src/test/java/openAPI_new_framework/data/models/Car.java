package openAPI_new_framework.data.models;

import lombok.Data;

@Data
public class Car {
    private String model;
    private boolean isAutomatic;

    public Car(String model, boolean isAutomatic) {
        this.model = model;
        this.isAutomatic = isAutomatic;
    }
}
