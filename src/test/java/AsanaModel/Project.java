package AsanaModel;

public class Project {

    private String gid;
    private String name;
    private String resource_type;

    public Project(String gid, String name, String resource_type) {
        this.gid = gid;
        this.name = name;
        this.resource_type = resource_type;
    }

    public Project() {
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkspace_type() {
        return resource_type;
    }

    public void setWorkspace_type(String workspace_type) {
        this.resource_type = workspace_type;
    }

    @Override
    public String toString() {
        return "Project{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", workspace_type='" + resource_type + '\'' +
                '}';
    }
}
