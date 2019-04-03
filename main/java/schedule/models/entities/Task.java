package schedule.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import schedule.models.dto.payloads.CreateTaskPayload;
import schedule.models.dto.payloads.UpdateTaskPayload;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity(name = "tasks")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "start_date")
    private Long begin;
    @Column(name = "finish_date")
    private Long end;
    @Column(name = "notes")
    private String notes;
    @ManyToOne(targetEntity = Project.class, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("tasks")
    private Project project;
    @Column(name = "planed")
    private boolean planed;
    @Column(name = "position")
    private int position;
    @Column(name = "deadline")
    private Long deadline;
    @Column(name = "list")
    private Long list;

    public Task(){

    }

    public Task(CreateTaskPayload createTaskPayload) {
        this.title = createTaskPayload.getTitle();
        this.begin = createTaskPayload.getStart();
        this.end = createTaskPayload.getEnd();
        this.notes = createTaskPayload.getNotes();
        this.deadline = createTaskPayload.getDeadline();
        if(createTaskPayload.getProject()!=null) this.project = new Project(createTaskPayload.getProject());
        this.planed = true;
        this.position = 0;
        if(createTaskPayload.getStart()==null) list=0L;
    }

    public void applyUpdates(UpdateTaskPayload updateTaskPayload){
        if(updateTaskPayload.getTitle()!=null) this.title = updateTaskPayload.getTitle();
        if(updateTaskPayload.getBegin()!=null) this.begin = updateTaskPayload.getBegin();
        if(updateTaskPayload.getDeadline()!=null) this.deadline = updateTaskPayload.getDeadline();
        if(updateTaskPayload.getEnd()!=null) this.end = updateTaskPayload.getEnd();
        if(updateTaskPayload.getNotes()!=null) this.notes = updateTaskPayload.getNotes();
        if(updateTaskPayload.getPosition()!=null) this.position = updateTaskPayload.getPosition();
        if(updateTaskPayload.getProject()!=null) this.project = new Project(updateTaskPayload.getProject());
        if(updateTaskPayload.getBegin()==null) this.list=0L;
        else this.list = null;
    }
}
