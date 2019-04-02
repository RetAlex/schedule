package schedule.controllers;

import org.springframework.web.bind.annotation.*;
import schedule.models.dto.payloads.CreateTaskPayload;
import schedule.models.dto.payloads.UpdateTaskPayload;
import schedule.models.dto.responces.IdResponse;
import schedule.models.entities.Task;
import schedule.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable("id") long id){
        return taskService.getTask(id);
    }

    @GetMapping("/tasks")
    public List<Task> getTasksInRange(@RequestParam("from") long from, @RequestParam("to") long to){
        return taskService.getTasks(from, to);
    }

    @PostMapping("/task")
    public IdResponse createTask(@RequestBody CreateTaskPayload payload){
        return new IdResponse(taskService.createTask(payload).getId());
    }

    @PatchMapping("/task/{id}")
    public void updateTask(@PathVariable("id") long id, @RequestBody UpdateTaskPayload payload){
        taskService.updateTask(payload, id);
    }
}
