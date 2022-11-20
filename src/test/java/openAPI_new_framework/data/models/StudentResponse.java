package openAPI_new_framework.data.models;

public class StudentResponse {
    private String status;
    private Data data;

    public StudentResponse() {
    }

    public StudentResponse(String status, Data data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "StudentResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
