package AsanaModel;

public class CreatedBy {


    private String name;

    public CreatedBy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CreatedBy{" +
                "name='" + name + '\'' +
                '}';
    }
}
