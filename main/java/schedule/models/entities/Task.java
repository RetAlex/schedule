package schedule.models.entities;

import lombok.Data;
import schedule.models.dto.payloads.CreateTaskPayload;
import schedule.models.dto.payloads.UpdateTaskPayload;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "tasks")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "start_date")
    private Date begin;
    @Column(name = "finish_date")
    private Date end;
    @Column(name = "notes")
    private String notes;
    @ManyToOne(targetEntity = Project.class, fetch = FetchType.LAZY, optional = false)
    private Project project;
    @Column(name = "planed")
    private boolean planed;
    @Column(name = "position")
    private int position;
    @Column(name = "deadline")
    private Date deadline;

    public Task(){

    }

    public Task(String title, Date begin, Date end, String notes, Project project, boolean planed, int position) {
        this.title = title;
        this.begin = begin;
        this.end = end;
        this.notes = notes;
        this.project = project;
        this.planed = planed;
        this.position = position;
    }

    public Task(CreateTaskPayload createTaskPayload) {
        this.title = createTaskPayload.getTitle();
        this.begin = createTaskPayload.getStart();
        this.end = createTaskPayload.getEnd();
        this.notes = createTaskPayload.getNotes();
        this.deadline = createTaskPayload.getDeadline();
        this.project = new Project(createTaskPayload.getProject());
        this.planed = true;
        this.position = 0;
    }

    public void applyUpdates(UpdateTaskPayload updateTaskPayload){
        if(updateTaskPayload.getTitle()!=null) this.title = updateTaskPayload.getTitle();
        if(updateTaskPayload.getBegin()!=null) this.begin = updateTaskPayload.getBegin();
        if(updateTaskPayload.getDeadline()!=null) this.deadline = updateTaskPayload.getDeadline();
        if(updateTaskPayload.getEnd()!=null) this.end = updateTaskPayload.getEnd();
        if(updateTaskPayload.getNotes()!=null) this.notes = updateTaskPayload.getNotes();
        if(updateTaskPayload.getPosition()!=null) this.position = updateTaskPayload.getPosition();
        if(updateTaskPayload.getProject()!=null) this.project = new Project(updateTaskPayload.getProject());
    }
}
