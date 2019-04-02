package schedule.controllers;

import org.springframework.web.bind.annotation.*;
import schedule.models.dto.payloads.CreateProjectPayload;
import schedule.models.dto.payloads.UpdateProjectPayload;
import schedule.models.dto.responces.IdResponse;
import schedule.services.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping("/project")
    public IdResponse createProject(@RequestBody CreateProjectPayload payload){
        return new IdResponse(service.createProject(payload).getId());
    }

    @PatchMapping("/project/{id}")
    public void updateProject(@RequestBody UpdateProjectPayload payload, @PathVariable("id") long id){
        //TODO make updateProject controller
        service.updateProject(payload, id);
    }
}
