package schedule.controllers;

import org.springframework.web.bind.annotation.*;
import schedule.models.dto.payloads.CreateTaskPayload;
import schedule.models.dto.payloads.UpdateTaskPayload;
import schedule.models.dto.responces.IdResponse;
import schedule.services.TaskService;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public IdResponse createTask(CreateTaskPayload payload){
        return new IdResponse(taskService.createTask(payload).getId());
    }

    @PatchMapping("/task/{id}")
    public void updateTask(@PathVariable("id") long id, @RequestBody UpdateTaskPayload payload){
        taskService.updateTask(payload, id);
    }
}
