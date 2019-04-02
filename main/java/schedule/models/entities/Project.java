package schedule.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import schedule.models.dto.payloads.CreateProjectPayload;
import schedule.models.dto.payloads.UpdateProjectPayload;

import javax.persistence.*;
import java.util.List;

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
    }

    public void applyUpdates(UpdateProjectPayload payload){
        if(payload.getColor()!=null) this.color = payload.getColor();
        if(payload.getDeadline()!=null) this.deadline = payload.getDeadline();
        if(payload.getName()!=null) this.name = payload.getName();
    }

    public Project(long id){
        this.id = id;
    }
}
