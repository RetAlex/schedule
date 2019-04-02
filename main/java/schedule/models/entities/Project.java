package schedule.models.entities;

import lombok.Data;
import schedule.models.dto.payloads.CreateProjectPayload;
import schedule.models.dto.payloads.UpdateProjectPayload;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "projects")
public class Project {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "deadline")
    private Date deadline;
    @Column(name = "color")
    private String color;
    @OneToMany(targetEntity = Task.class, mappedBy = "project")
    private List<Task> tasks;

    public Project() {
    }

    public Project(String name, Date deadline, String colour, List<Task> tasks) {
        this.name = name;
        this.deadline = deadline;
        this.color = colour;
        this.tasks = tasks;
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
