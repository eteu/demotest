package toto.test.demotest.models;

public class Project {
    private long id;
    private String name;

    public Project(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Project() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
