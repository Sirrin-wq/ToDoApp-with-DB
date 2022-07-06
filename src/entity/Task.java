package entity;

public class Task {
    private int id;
    private String description;
    private String name;
    private String status;

    public Task() {
    }

    public Task(String description, String name, String status) {
        this.description = description;
        this.name = name;
        this.status = status;
    }

    public Task(int id, String description, String name, String status) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
