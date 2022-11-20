package openAPI_new_framework.data.models;

public class Data {
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;

    public Data() {
    }

    public Data(String first_name, String middle_name, String last_name, String date_of_birth, int id) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
}
