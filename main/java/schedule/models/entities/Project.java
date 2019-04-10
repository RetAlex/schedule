package schedule.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import schedule.models.dto.payloads.CreateProjectPayload;
import schedule.models.dto.payloads.UpdateProjectPayload;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity(name = "projects")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "deadline")
    private Long deadline;
    @Column(name = "color")
    private String color;
    @OneToMany(targetEntity = Task.class, mappedBy = "project")
    @JsonIgnoreProperties("project")
    private List<Task> tasks;

    public Project() {
    }

    public Project(CreateProjectPayload payload){
        this.color = payload.getColor();
        this.name = payload.getName();
        this.deadline = payload.getDeadline();
        tasks = new ArrayList<>();
    }

    public void applyUpdates(UpdateProjectPayload payload){
        if(payload.getColor()!=null) this.color = payload.getColor();
        if(payload.getDeadline()!=null) this.deadline = payload.getDeadline();
        if(payload.getName()!=null) this.name = payload.getName();
    }

    public Project(long id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                name.equals(project.name) &&
                Objects.equals(deadline, project.deadline) &&
                Objects.equals(color, project.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deadline, color);
    }
}
