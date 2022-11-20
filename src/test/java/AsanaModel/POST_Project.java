package AsanaModel;



public class POST_Project {

    private Data data;

    public POST_Project() {
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "POST_Project{" +
                "data=" + data +
                '}';
    }
}