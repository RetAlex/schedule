package schedule.controllers;

import org.springframework.web.bind.annotation.*;
import schedule.models.dto.payloads.CreateProjectPayload;
import schedule.models.dto.payloads.UpdateProjectPayload;
import schedule.models.dto.responces.IdResponse;
import schedule.models.entities.Project;
import schedule.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping("/project/{id}")
    public Project getProject(@PathVariable("id") long id){
        return service.getProject(id);
    }

    @GetMapping("/project")
    public List<Project> getProjects(){
        return service.getProjects();
    }

    @PostMapping("/project")
    public IdResponse createProject(@RequestBody CreateProjectPayload payload){
        return new IdResponse(service.createProject(payload).getId());
    }

    @PatchMapping("/project/{id}")
    public void updateProject(@RequestBody UpdateProjectPayload payload, @PathVariable("id") long id){
        service.updateProject(payload, id);
    }
}
